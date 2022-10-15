FROM openjdk:11

COPY target/taskmanagmentwithmongo.jar taskmanagmentwithmongo.jar

ENTRYPOINT ["java","-jar" ,"/taskmanagmentwithmongo.jar"]