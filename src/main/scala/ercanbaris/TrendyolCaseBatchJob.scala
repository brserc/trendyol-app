package ercanbaris

import org.apache.flink.api.scala._
import org.apache.flink.util.Collector
import org.apache.flink.core.fs.FileSystem

object TrendyolCaseBatchJob {
  def main(args: Array[String]): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    val data: DataSet[UserAction] = env.readCsvFile[UserAction](filePath = "/trendyol_docker/case.csv",fieldDelimiter = "|",ignoreFirstLine = true)

    DataProcessor.uniqueProductViewByProductId(data).writeAsCsv("/trendyol_docker/results/uniqueProductViewByProductId.txt", "\n", "|", writeMode = FileSystem.WriteMode.OVERWRITE);
    DataProcessor.uniqueEventCounts(data).writeAsCsv("/trendyol_docker/results/uniqueEventCounts.txt", "\n", "|",writeMode = FileSystem.WriteMode.OVERWRITE);
    DataProcessor.topFiveFulfilledAllEvents(data).writeAsCsv("/trendyol_docker/results/topFiveFulfilledAllEvents.txt", "\n", "|",writeMode = FileSystem.WriteMode.OVERWRITE);
    DataProcessor.allEventsOfUser(data,47).writeAsCsv("/trendyol_docker/results/allEventsOfUser.txt", "\n", "|",writeMode = FileSystem.WriteMode.OVERWRITE);
    DataProcessor.productViewsOfUser(data,47).writeAsCsv("/trendyol_docker/results/productViewsOfUser.txt", "\n", "|",writeMode = FileSystem.WriteMode.OVERWRITE);
    env.execute("Trendyol")
  }
}

