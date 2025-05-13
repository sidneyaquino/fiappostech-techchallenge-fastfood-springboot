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
   -Dspring.backgroundpreinitializer.ignore=true \
   -XX:+UnlockExperimentalVMOptions -XX:ShenandoahGCMode=generational \
   -XX:ArchiveClassesAtExit=./app.jsa -Dspring.context.exit=onRefresh \
   org.springframework.boot.loader.launch.JarLauncher

FROM docker.io/bellsoft/liberica-runtime-container:jre-24-cds-slim-musl AS runner
# FROM docker.io/bellsoft/liberica-openjre-alpine-musl:24-cds AS runner
WORKDIR /app
COPY --chmod=755 --from=optimizer /tmp ./
RUN adduser --disabled-password -u 10001 nonroot \
   && echo "nonroot:x:10001:10001:App User:/:/sbin/nologin" > /etc/minimal-passwd
USER nonroot
SHELL ["/bin/sh", "-c"]
CMD java -Dserver.port=$PORT $JAVA_OPTS \
   -Dfile.encoding=UTF-8 \
   -Dspring.aot.enabled=true \
   -Dspring.backgroundpreinitializer.ignore=true \
   -XX:+UseContainerSupport -XX:MaxRAMPercentage=80.0 \
   -XX:+UnlockExperimentalVMOptions -XX:ShenandoahGCMode=generational \
   -XX:SharedArchiveFile=./app.jsa -Xshare:on \
   org.springframework.boot.loader.launch.JarLauncher