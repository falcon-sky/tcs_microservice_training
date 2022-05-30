#Build

mvn clean install

# Run
docker-compose -f docker-compose-rabbitmq.yml up -d
rabbitmq-demo-consumer> mvn spring-boot:run
rabbitmq-demo-producer> mvn spring-boot:run

# Test
curl --location --request GET 'http://localhost:8080/rabbitmq/producer?empName=employee2&empId=id2'

#Show data on browser::

http://localhost:15672/

user-name:guest
password:guest


## Stop Container

docker-compose -f docker-compose-rabbitmq.yml down