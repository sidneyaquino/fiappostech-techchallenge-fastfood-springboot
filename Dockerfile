FROM docker.io/bellsoft/liberica-native-image-kit-container:jdk-21-nik-23-musl AS builder
WORKDIR /tmp
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN --mount=type=cache,target=/root/.m2 \
   ./mvnw dependency:resolve
COPY src/ src
RUN --mount=type=cache,target=/root/.m2 \
   ./mvnw compile spring-boot:process-aot package -DskipTests -Djacoco.skip
RUN mkdir -p target/dependency && \
   (cd target/dependency; jar -xf ../*.jar)

FROM docker.io/bellsoft/liberica-runtime-container:jre-21-slim-musl
ARG DEPENDENCY=/tmp/target/dependency
COPY --chmod=755 --from=builder ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --chown=755 --from=builder ${DEPENDENCY}/META-INF /app/META-INF
COPY --chown=755 --from=builder ${DEPENDENCY}/BOOT-INF/classes /app
RUN addgroup --system nonroot && \
   adduser -S -s /usr/sbin/nologin -D -H -G nonroot nonroot
USER nonroot:nonroot
SHELL ["/bin/sh", "-c"]
CMD java -Dserver.port=$PORT $JAVA_OPTS -Dspring.aot.enabled=true \
   -cp app:app/lib/* com.fiappostech.fastfood.FastfoodApplication