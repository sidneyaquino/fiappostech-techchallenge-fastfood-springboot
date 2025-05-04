# FROM docker.io/bellsoft/liberica-native-image-kit-container:jdk-24-nik-24-glibc AS builder
FROM ghcr.io/graalvm/native-image-community:24 AS builder
WORKDIR /tmp
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN --mount=type=cache,target=/root/.m2 \
   ./mvnw dependency:resolve
COPY src/ src
RUN --mount=type=cache,target=/root/.m2 \
   ./mvnw compile spring-boot:process-aot package \
      -DskipTests -Djacoco.skip -Dmaven.compiler.proc=full 
RUN java -Djarmode=tools -jar target/*.jar \
      extract --layers --launcher --destination target/extracted

FROM docker.io/bellsoft/liberica-runtime-container:jre-24-cds-slim-musl AS optimizer
# FROM docker.io/bellsoft/liberica-openjre-alpine-musl:24-cds AS optimizer
WORKDIR /tmp
ENV DEPENDENCY=/tmp/target/extracted
COPY --from=builder ${DEPENDENCY}/dependencies/ ./
COPY --from=builder ${DEPENDENCY}/spring-boot-loader/ ./
COPY --from=builder ${DEPENDENCY}/snapshot-dependencies/ ./
COPY --from=builder ${DEPENDENCY}/application/ ./
RUN java \
      -Dspring.aot.enabled=true \
      -XX:ArchiveClassesAtExit=./app.jsa -Dspring.context.exit=onRefresh \
      org.springframework.boot.loader.launch.JarLauncher

FROM docker.io/bellsoft/liberica-runtime-container:jre-24-cds-slim-musl AS runner
# FROM docker.io/bellsoft/liberica-openjre-alpine-musl:24-cds AS runner
WORKDIR /app
COPY --chmod=755 --from=optimizer /tmp ./
RUN addgroup --system nonroot && \
   adduser -S -s /usr/sbin/nologin -D -H -G nonroot nonroot
USER nonroot:nonroot
SHELL ["/bin/sh", "-c"]
CMD java -Dserver.port=$PORT $JAVA_OPTS \
      -XX:+UseContainerSupport \
      -XX:MaxRAMPercentage=75.0 \
      -Dspring.aot.enabled=true \
      -XX:SharedArchiveFile=./app.jsa -Xshare:on \
      org.springframework.boot.loader.launch.JarLauncher