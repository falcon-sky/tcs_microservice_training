#Build

mvn clean install

# Run
```
docker-compose -f docker-compose-mysql.yml up -d

mvn spring-boot:run

docker-compose -f docker-compose-mysql.yml down

```

# training
##POST

```
curl -X POST \
http://localhost:8080/user/create -H 'content-type: application/json' -d '{"name": "Rama","teamName": "beta","salary": 23000 }'

```

## Get 

```

```
curl -X GET http://localhost:8080/user/read 
