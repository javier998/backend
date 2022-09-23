# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
    FROM openjdk:8
    ADD target/roles-2.7.3-SNAPSHOT.jar roles-2.7.3-SNAPSHOT.jar
    ARG JAR_FILE=target/*.jar
    COPY ${JAR_FILE} roles-2.7.3-SNAPSHOT.jar
    ENTRYPOINT ["java", "-jar","roles-2.7.3-SNAPSHOT.jar"]
    EXPOSE 8080