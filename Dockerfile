FROM adoptopenjdk/openjdk11
COPY *jar /app.jar
CMD ["--server.port=8081"]
EXPOSE 10270
ENTRYPOINT ["java","-jar","/app.jar"]
