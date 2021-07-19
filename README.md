# kafka-zensar-project

This is project is about building the backend applications that uses the spring data JPA, docker, kafka and MySql. In this context,
our applications will be running on docker.

This project is about reading a file from filesystem(directory (json file). 
Json file is read from the directory, and the content is produced to kafka topic. 
The content is push through REST API. Read the data from kafka and persist the data into MySQL.

**Technologies**

Docker
* Spring Boot
* Apache kafka and zookeeper
* Databases(mysql and sqlserver)

**Install**

* Install JDK java 11
* Install docker
* Eclipse/IDEA/other tools

**Running our applications(kafka-consumer-file and kafka-producer-file)**

1. **git clone the code**
```
git clone https://github.com/NhlamuloChauke/kafka-zensar-project.git
```

2. **Run spring-boot and docker containers(for mysql, kafka, consumer and producer):**
```
cd kafka-zensar-project
ls

README.md			data			  kafka-consumer-file		mysql-init
Zensar Solution Document.pages	      docker-compose.yml		kafka-producer-file

cd data
cat Person.json
{
  "id":"10", 
  "gender":"male",
  "firstname":"John",
  "lastname":"Doe"
 }

cd ../kafka-zensar-project

cd kafka-consumer-file
mvn clean install

cd ../kafka-zensar-project
cd kafka-producer-file
mvn clean install

cd ../kafka-zensar-project
docker-compose up -d kafka-mysql-db
docker-compose up -d kafka-cluster
docker-compose build kafka-consumer-file
docker-compose up -d kafka-consumer-file
docker-compose build kafka-producer-file
docker-compose up -d kafka-producer-file

docker ps 
```

3. **Json file is read from the directory(/data)**
```
{
 "id":"10", 
 "gender":"male",
 "firstname":"John",
 "lastname":"Doe"
}
```

4. Json data is read from the directory, and the content is pushed to kafka topic with **kafka-producer-file** service.
   The content is push through REST API.

   **REST API**
   ```
   # send file to a kafka topic (kafka-producer-file)
    curl -X POST http://localhost:9002/send

   # get all the persisted data from the database(kafka-consumer-file)
   curl -X GET http://localhost:9091/persons
   ```
