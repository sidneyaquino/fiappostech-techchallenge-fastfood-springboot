FROM container-registry.oracle.com/graalvm/native-image-community:21 AS build
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

FROM docker.io/bellsoft/liberica-runtime-container:jre-21-slim-glibc AS runtime
RUN addgroup --system javauser && \
   adduser -S -s /usr/sbin/nologin -D -H -G javauser javauser
ARG DEPENDENCY=/tmp/target/dependency
COPY --chown=javauser --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --chown=javauser --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --chown=javauser --from=build ${DEPENDENCY}/BOOT-INF/classes /app
USER javauser
SHELL ["/bin/sh", "-c"]
CMD java -Dserver.port=$PORT $JAVA_OPTS -Dspring.aot.enabled=true -cp app:app/lib/* \
   com.fiappostech.fastfood.FastfoodApplication