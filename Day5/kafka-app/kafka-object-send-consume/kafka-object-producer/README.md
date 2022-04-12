# Project
This Apllication is use understand the basic kafka message producer in sprict boot application.

## Import project
Import the project on either eclipse or inellij as a maven import project

## Building

### Maven
This project is maven project which will be build using maven command.

```bash
$ mvn clean install
```

## Running

The application can be start is either locally using maven or start in docker container.

### Running the application in local environment
Using eclipse:It can be run as java application or run configuration to provide the program arguments.
You can run using maven command as:

```bash
$ mvn spring-boot:run -Dspring-boot.run.profiles=local
```

## Testing
 1)Publish using default topic test.topic
 
 ```
curl -X POST 'http://127.0.0.1:9095/publish/data?message=mydata'
 ```

## Command line execution

1) Enter to container

	´´´
	docker exec -it <container Id> bash
	Ex : docker exec -it 1d6716fa6b56 bash

	´´´
2) Look for topics created

	´´´
	kafka-topics --zookeeper localhost --topic  <TAB><TAB>

	´´´
3) configure  topic
    
    ´´´
	kafka-topics --config <TAB><TAB>

	´´´
4) consumer

	kafka-console-consumer -- <TAB><TAB>


