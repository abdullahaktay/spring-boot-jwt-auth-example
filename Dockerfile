FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY build/libs/jwt-0.0.1-SNAPSHOT.jar jwt-0.0.1-SNAPSHOT.jar

RUN useradd --create-home appuser

USER appuser

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "jwt-0.0.1-SNAPSHOT.jar"]