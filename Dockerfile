# Use the official OpenJDK image as the base image
FROM openjdk:17-oracle

# Set the working directory in the Docker image
WORKDIR /app

# Copy the built JAR file into the Docker image
ARG JAR_FILE=pricing-server/target/*.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java","-jar","app.jar"]