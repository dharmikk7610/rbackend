FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY  target/Royaltechnosoft-0.0.1-SNAPSHOT.jar /app/Royaltechnosoft-0.0.1-SNAPSHOT.jar

EXPOSE 9999

ENTRYPOINT [ "java","-jar","Royaltechnosoft-0.0.1-SNAPSHOT.jar" ]
