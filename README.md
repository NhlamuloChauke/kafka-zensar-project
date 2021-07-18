# kafka-zensar-project
Read a file from filesystem. Push the data to Kafka. Read the data from Kafka and persist the data into MongoDB/MySQL.
Docker is being used to deploy our code.

**How to Run our services(kafka-consumer-file and kafka-producer-file)**

1. **git clone the code**
```
git clone https://github.com/NhlamuloChauke/kafka-zensar-project.git
```

2. **Run spring-boot and docker containers(for mysql, kafka, consumer and producer):**
```
cd kafka-zensar-project
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