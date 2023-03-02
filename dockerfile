FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar find-best-plan.jar
ENTRYPOINT ["java","-jar","/find-best-plan.jar"]