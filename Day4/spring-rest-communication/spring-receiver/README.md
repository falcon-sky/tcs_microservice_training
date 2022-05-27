# Build
mvn clean install

# Run
mvn spring-boot:run

# Test
curl --location --request GET 'localhost:10082/receiver/get'
