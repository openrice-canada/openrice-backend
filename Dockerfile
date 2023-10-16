# Use the official image as a parent image
FROM openjdk:19-jdk-slim

# Set the working directory in Docker
WORKDIR /app

# Copy the Gradle wrapper JAR and properties to the Docker container at `/app`
COPY gradle/wrapper/gradle-wrapper.jar gradle/wrapper/gradle-wrapper.jar
COPY gradle/wrapper/gradle-wrapper.properties gradle/wrapper/gradle-wrapper.properties

# Copy the Gradle wrapper script `gradlew` to the Docker container at `/app`
COPY gradlew gradlew
RUN chmod +x gradlew

# Copy the `build.gradle` and `settings.gradle` (or `build.gradle.kts` and `settings.gradle.kts` for Kotlin DSL) to the Docker container
COPY build.gradle build.gradle
COPY settings.gradle settings.gradle

# Cache dependencies (for faster builds)
RUN ./gradlew build --exclude-task test

# Copy the rest of the application code
COPY src src

# Expose port 8080 for the application
EXPOSE 8080

# Specify the command to run on container start
CMD ["./gradlew", "bootRun"]
