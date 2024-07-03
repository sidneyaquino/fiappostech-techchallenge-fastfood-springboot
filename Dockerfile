FROM docker.io/bellsoft/liberica-runtime-container:jdk-21-slim-musl AS builder
WORKDIR /tmp
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN --mount=type=cache,target=/root/.m2 \
   ./mvnw dependency:resolve
COPY src/ src
RUN --mount=type=cache,target=/root/.m2 \
   ./mvnw compile spring-boot:process-aot package -DskipTests -Djacoco.skip
RUN mkdir -p target/extracted && \
   (cd target/extracted; jar -xf ../*.jar)

FROM scratch AS organizer
WORKDIR /tmp
ENV DEPENDENCY=/tmp/target/extracted
COPY --from=builder ${DEPENDENCY}/BOOT-INF/lib ./lib
COPY --from=builder ${DEPENDENCY}/META-INF ./META-INF
COPY --from=builder ${DEPENDENCY}/BOOT-INF/classes ./

FROM docker.io/bellsoft/liberica-runtime-container:jdk-21-slim-musl
COPY --chmod=755 --from=organizer /tmp /app
RUN addgroup --system nonroot && \
   adduser -S -s /usr/sbin/nologin -D -H -G nonroot nonroot
USER nonroot:nonroot
SHELL ["/bin/sh", "-c"]
CMD java -Dserver.port=$PORT $JAVA_OPTS -Dspring.aot.enabled=true \
   -cp app:app/lib/* com.fiappostech.fastfood.FastfoodApplication