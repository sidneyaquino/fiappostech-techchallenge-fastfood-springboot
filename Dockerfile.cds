FROM docker.io/bellsoft/liberica-runtime-container:jdk-21-cds-slim-musl AS builder
WORKDIR /tmp
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN --mount=type=cache,target=/root/.m2 \
   ./mvnw dependency:resolve
COPY src/ src
RUN --mount=type=cache,target=/root/.m2 \
   ./mvnw compile spring-boot:process-aot package -DskipTests -Djacoco.skip
RUN java -Djarmode=tools -jar target/*.jar \
   extract --layers --launcher --destination target/extracted

FROM docker.io/bellsoft/liberica-runtime-container:jre-21-cds-slim-musl AS otimizer
WORKDIR /tmp
ARG DEPENDENCY=/tmp/target/extracted
COPY --from=builder ${DEPENDENCY}/dependencies/ ./
COPY --from=builder ${DEPENDENCY}/spring-boot-loader/ ./
COPY --from=builder ${DEPENDENCY}/snapshot-dependencies/ ./
COPY --from=builder ${DEPENDENCY}/application/ ./
ENV DB_HOST=localhost
RUN --network=host java -Dspring.aot.enabled=true \
   -XX:ArchiveClassesAtExit=./app.jsa -Dspring.context.exit=onRefresh \
   org.springframework.boot.loader.launch.JarLauncher

FROM docker.io/bellsoft/liberica-runtime-container:jre-21-cds-slim-musl
WORKDIR /app
COPY --chmod=755 --from=otimizer /tmp ./
RUN addgroup --system nonroot && \
   adduser -S -s /usr/sbin/nologin -D -H -G nonroot nonroot
USER nonroot:nonroot
SHELL ["/bin/sh", "-c"]
CMD java -Dserver.port=$PORT $JAVA_OPTS -Dspring.aot.enabled=true \
   -XX:SharedArchiveFile=./app.jsa \
   org.springframework.boot.loader.launch.JarLauncher