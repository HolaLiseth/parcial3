FROM openjdk:17
COPY ".\target\Parcial3-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8017
ENTRYPOINT [ "java", "-jar", "app.jar"]