FROM openjdk:17-oracle

WORKDIR /app
COPY . .

COPY ./target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]