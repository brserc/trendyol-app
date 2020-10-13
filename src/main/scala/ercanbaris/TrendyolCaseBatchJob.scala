package ercanbaris

import org.apache.flink.api.scala._
import java.nio.file.Paths
import ercanbaris.UserAction

object TrendyolCaseBatchJob {
  def main(args: Array[String]): Unit = {

    val env = ExecutionEnvironment.getExecutionEnvironment
    val data: DataSet[UserAction] = env.readCsvFile[UserAction](filePath = "./src/main/resources/case.csv",fieldDelimiter = "|",ignoreFirstLine = true)
    data.print

  }
}
