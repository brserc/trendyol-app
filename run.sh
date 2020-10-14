docker-compose down
docker-compose up -d --build
docker exec -it $(docker ps --filter name=jobmanager --format={{.ID}}) flink run /trendyol_docker/trendyol-app-assembly-0.1-SNAPSHOT.jar