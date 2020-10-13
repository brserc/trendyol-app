package ercanbaris

import org.apache.flink.api.scala._
import java.nio.file.Paths
import ercanbaris.UserAction

object TrendyolCaseBatchJob {
  def main(args: Array[String]): Unit = {

    val env = ExecutionEnvironment.getExecutionEnvironment
    val data: DataSet[UserAction] = env.readCsvFile[UserAction](filePath = "./src/main/resources/case.csv",fieldDelimiter = "|",ignoreFirstLine = true)
    val distinctproduct = data.filter{_.eventName == "view"}.map{ua => (ua.productId,1)}.groupBy(0).sum(1)
    distinctproduct.print

    val uniqueevents = data.map{ua => (ua.eventName,1)}.groupBy(0).sum(1)
    uniqueevents.print

  }
}
