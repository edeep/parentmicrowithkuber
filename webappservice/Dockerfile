FROM openjdk:17-jdk-slim

WORKDIR /app

COPY /target/webappservice-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port your app runs on
EXPOSE 8030

# Command to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]