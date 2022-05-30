#Build

mvn clean install

# Run
docker-compose -f docker-compose-artemis.yml up -d
artemis-demo-consumer> mvn spring-boot:run
artemis-demo-producer> mvn spring-boot:run

# Test
curl -X GET 'http://localhost:1230/send?msg=rama'

## Stop Container

docker-compose -f docker-compose-artemis.yml down

#Show data::

http://localhost:8161/


