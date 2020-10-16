package ercanbaris

import org.apache.flink.api.scala._
import org.apache.flink.util.Collector

object TrendyolCaseBatchJob {
  def main(args: Array[String]): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    //val data: DataSet[UserAction] = env.readCsvFile[UserAction](filePath = "src/main/resources/case.csv",fieldDelimiter = "|",ignoreFirstLine = true)
    val data: DataSet[UserAction] = env.readCsvFile[UserAction](filePath = "/trendyol_docker/case.csv",fieldDelimiter = "|",ignoreFirstLine = true)




  }
}

//.filter{_._1 != 4}
