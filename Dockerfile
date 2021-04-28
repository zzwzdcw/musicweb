FROM java:latest
VOLUME /tmp
ADD target/musicweb-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
