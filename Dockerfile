# ---- Build stage ----
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# copy pom first (better cache)
COPY pom.xml .
COPY src ./src

# build jar
RUN mvn clean package -DskipTests


# ---- Run stage ----
FROM eclipse-temurin:17-jdk

WORKDIR /app

# copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]