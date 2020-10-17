FROM flink:1.11.2-scala_2.12-java11

RUN mkdir -p /trendyol_docker/results/
COPY ./src/main/resources/case.csv /trendyol_docker/
COPY ./target/scala-2.12/trendyol-app-assembly-0.1-SNAPSHOT.jar /trendyol_docker/
RUN chown -R flink:flink /trendyol_docker/
RUN ls -la /trendyol_docker/
RUN usermod -u 1000 flink
RUN usermod -G staff flink
