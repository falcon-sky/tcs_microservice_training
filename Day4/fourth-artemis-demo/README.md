#Build

mvn clean install

# Run
docker-compose -f docker-compose-artemis.yml up -d
mvn spring-boot:run

# Test
curl -X GET \
'http://localhost:1230/send?msg=rama' \

#Show data::

http://localhost:8161/


