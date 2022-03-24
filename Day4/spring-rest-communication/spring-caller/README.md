## Build
mvn clean install

## Run
mvn spring-boot:run

## Create Docker Image

mvn clean install -Pjib -DjibComponent=spring-caller -DnewVersion=1 -DskipTests

## Run docker container

docker run -p 10081:10081 --rm --name caller spring-caller:1

docker run -p 10081:10081 --network=host --rm --name caller spring-caller:1 

docker run -p 10081:10081 --add-host host.docker.internal:host-gateway --rm --name caller spring-caller:1 

