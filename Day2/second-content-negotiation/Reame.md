<Student>
    <name>Shanker</name>
    <roll>1re106</roll>
</Student>

{
  "name": "Rama",
  "roll": "1re206"
}

insert into student
values(10,'Rama', '1re06');

insert into student
values(11,'Shanker', '1re07');


curl -X POST \
http://localhost:8080/students/ \
-H 'cache-control: no-cache' \
-H 'content-type: application/xml' \
-d '<Student>
<name>Shanker</name>
<roll>1re106</roll>
</Student>'

curl -X GET \
http://localhost:8080/students/ \
-H 'accept: application/xml' \
-H 'cache-control: no-cache' \
-H 'postman-token: cee55e76-0535-3619-20f9-d39d0aa7aa70'


curl -X PUT \
http://localhost:8080/students/1 \
-H 'cache-control: no-cache' \
-H 'content-type: application/xml' \
-d '<Student>
<name>Rama</name>
<roll>1re106</roll>
</Student>'
