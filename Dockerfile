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
RUN mkdir -p target/extracted && \
      (cd target/extracted; jar -xf ../*.jar)

FROM scratch AS optimizer
WORKDIR /tmp
ENV DEPENDENCY=/tmp/target/extracted
COPY --from=builder ${DEPENDENCY}/BOOT-INF/lib ./lib
COPY --from=builder ${DEPENDENCY}/META-INF ./META-INF
COPY --from=builder ${DEPENDENCY}/BOOT-INF/classes ./

FROM docker.io/bellsoft/liberica-runtime-container:jre-24-slim-musl AS runner
# FROM docker.io/bellsoft/liberica-openjre-alpine-musl:24 AS runner
COPY --chmod=755 --from=optimizer /tmp /app
RUN addgroup --system nonroot && \
   adduser -S -s /usr/sbin/nologin -D -H -G nonroot nonroot
USER nonroot:nonroot
SHELL ["/bin/sh", "-c"]
CMD java -Dserver.port=$PORT $JAVA_OPTS \
      -XX:+UseContainerSupport \
      -XX:MaxRAMPercentage=75.0 \
      -Dspring.aot.enabled=true \
      -cp app:app/lib/* com.fiappostech.fastfood.FastfoodApplication