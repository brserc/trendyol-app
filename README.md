# Trendyol Data Case

This project is made for Trendyol Tech interview process.

## Description

Application reads user data and creates various statistics using Apache Flink and writes them under /src/main/resources/results.

Application has a model class for reading User Action -which is a case class- from csv files. It then transforms this data using Apache Flink Dataset and various functions provided by it(filter,map,reduce,groupby). Processor functions are in DataProcessor.scala, they take DataSet's combined of UserAction's and return a dataset in the expected tuple. Other than that the execution of application is trivial.

Application runs on Docker. docker-compose.yml defines two containers for JobManager and TaskManager processes in Apache Flink to run. In the dockerfile we put the jar into container and give necessary permissions.

After running application you can access to flink dashboard via http://localhost:8081/ 

## Dependencies


## Usage

Compile and run tests : 
```
sbt clean assembly
```
Run app in container : 
```
./run.sh
```

or : 

```
docker-compose down
docker-compose up -d --build
docker exec -u root -it $(docker ps --filter name=jobmanager --format={{.ID}}) flink run /trendyol_docker/trendyol-app-assembly-0.1-SNAPSHOT.jar
```

### Testing

Unit tests are written in BDD style. We used a fake data set as input and functions are expected to return provided outputs. Running sbt assembly automatically runs tests. Otherwise you can use : 
Compile and run tests : 
```
sbt test
```

## Authors

Baris Ercan - b.barisercan@gmail.com