FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B # cache the dependencies

COPY src ./src

RUN mvn clean package -DskipTests

# this steps helps to run the code
FROM eclipse-temurin:21-alpine AS runner

WORKDIR /app

COPY --from=builder ./app/target/patient-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 4000

ENTRYPOINT ["java","-jar","app.jar"]