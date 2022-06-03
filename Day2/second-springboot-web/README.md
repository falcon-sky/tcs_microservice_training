# Project
This Apllication is use understand the basic security mechanism in sprict boot application.

## Import project
Import the project on either eclipse or inellij as a maven import project

## Building

### Maven
This project is maven project which will be build using maven command.

```bash
$ mvn clean install
$ mvn spring-boot:run

```

### Create docker image:

```
docker build -t falcon007/second-springboot-web:1.0.0 .

```

### Push docker images

```bash
docker login
$ docker push falcon007/second-springboot-web:1.0.0
```


### Test Command

```bash
docker login
$ docker push falcon007/second-springboot-web:1.0.0
```