# Project
This Apllication is use understand the basic security mechanism in sprict boot application.

##
Create Project

```bash
$mvn archetype:generate -DgroupId=com.rama.data -DartifactId=spring-project -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
## Import project
Import the project on either eclipse or inellij as a maven import project

## Building

### Maven
This project is maven project which will be build using maven command.

```bash
$ mvn clean install
```

## Dockerization

### Maven
wouterd
alexec
spotify
fabric8io

Here i am using maven spotify plugin to create the docker image for this application.
Use the below command to create the docker image.
For creating please use your repository to create the image which will be easy to push image in your docker hub.
update in your pom.xml.
<docker.image.prefix> <your repo name> </docker.image.prefix>

```bash
$ mvn install dockerfile:build
```

### Push docker images

```bash
docker login
$ docker push <repository-name>/springsecurity
```

## Running

The application can be start is either locally using maven or start in docker container.

### Running the application in local environment
Using eclipse:It can be run as java application or run configuration to provide the program arguments.
You can run using maven command as:

```bash
$ mvn spring-boot:run
```

### Running the application in docker container

```bash
$ docker run -p 8080:8080 falcon007/spring-boot-app:0.0.1 
$ docker-compose  pull
$ docker-compose  up
```

## Looking docker image

docker exec -it c555dfd07277 bash

## Testing

http://localhost:8080/


