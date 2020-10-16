package ercanbaris

import org.apache.flink.api.scala._
import org.apache.flink.util.Collector

object TrendyolCaseBatchJob {
  def main(args: Array[String]): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    val data: DataSet[UserAction] = env.readCsvFile[UserAction](filePath = "/trendyol_docker/case.csv",fieldDelimiter = "|",ignoreFirstLine = true)

    DataProcessor.uniqueProductViewByProductId(data).writeAsCsv("./main/resources/results/uniqueProductViewByProductId.csv", "\n", "|");
    DataProcessor.uniqueEventCounts(data).writeAsCsv("./main/resources/results/uniqueEventCounts.csv", "\n", "|");
    DataProcessor.topFiveFulfilledAllEvents(data).writeAsCsv("./main/resources/results/topFiveFulfilledAllEvents.csv", "\n", "|");
    DataProcessor.allEventsOfUser(data,47).writeAsCsv("./main/resources/results/allEventsOfUser.csv", "\n", "|");
    DataProcessor.productViewsOfUser(data,47).writeAsCsv("./main/resources/results/productViewsOfUser.csv", "\n", "|");

  }
}

