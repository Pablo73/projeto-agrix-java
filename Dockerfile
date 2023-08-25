# 1º estágio
FROM maven:3-openjdk-17 as build-image
WORKDIR /to-build-app
RUN mvn dependency:go-offline
COPY . .
RUN mvn clean package -DskipTests

# 2º estágio
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build-image /to-build-app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]