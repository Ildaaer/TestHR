FROM maven:latest AS stage1
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:resolve
COPY . /app
RUN mvn clean
RUN mvn package -DskipTests

FROM openjdk:20 as final
COPY --from=stage1 /app/target/*.jar TestHR-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "TestHR-0.0.1-SNAPSHOT.jar"]