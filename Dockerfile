FROM openjdk:11-jre-slim
COPY ./build/libs/ktor-app.jar /app/ktor-app.jar
EXPOSE 8080
CMD ["java", "-server", "-jar", "/app/ktor-app.jar"]