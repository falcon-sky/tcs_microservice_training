#Build

mvn clean install

# Run
docker-compose -f docker-compose-mysql.yml up -d
mvn spring-boot:run

# training
Post:http://localhost:8080/customer/create?name=shanker&custId=12&address=bangalore
Get Read all:http://localhost:8080/customer/read
Delete by name:http://localhost:8080/customer/delete?name=shanker



{
  "name": "Rama",
  "team_name": "alpha",
  "salary": 23000
}
