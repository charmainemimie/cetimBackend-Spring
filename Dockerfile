# Stage 1: Build the application using official Java 26 base image
FROM eclipse-temurin:26-jdk-jammy AS build
WORKDIR /app

# Install Maven inside the container
RUN apt-get update && apt-get install -y maven

# FIX: Copy the pom.xml first, then the src directory properly
COPY pom.xml .
COPY src ./src

# Now Maven will find the pom.xml in /app and the source code in /app/src
RUN mvn clean package -DskipTests

# Stage 2: Run the application using Java 26 Runtime
FROM eclipse-temurin:26-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]