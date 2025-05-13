FROM docker.io/bellsoft/liberica-native-image-kit-container:jdk-24-nik-24-musl AS builder
# FROM ghcr.io/graalvm/native-image-community:24-muslib AS builder
WORKDIR /tmp
ADD .mvn/ .mvn
ADD mvnw pom.xml ./
RUN --mount=type=cache,target=/root/.m2 \
   ./mvnw dependency:go-offline
ADD src/ src
RUN --mount=type=cache,target=/root/.m2 \
   ./mvnw compile spring-boot:process-aot package \
   -Dmanven.test.skip=true -DskipTests -Djacoco.skip
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
RUN adduser --disabled-password -u 10001 nonroot \
   && echo "nonroot:x:10001:10001:App User:/:/sbin/nologin" > /etc/minimal-passwd
USER nonroot
SHELL ["/bin/sh", "-c"]
CMD java -Dserver.port=$PORT $JAVA_OPTS \
   -Dfile.encoding=UTF-8 \
   -Dspring.aot.enabled=true \
   -Dspring.backgroundpreinitializer.ignore=true \
   -XX:+UseContainerSupport -XX:MaxRAMPercentage=80.0 \
   -XX:+UnlockExperimentalVMOptions -XX:ShenandoahGCMode=generational -XX:+UseCompactObjectHeaders \
   -cp app:app/lib/* com.fiappostech.fastfood.FastfoodApplication