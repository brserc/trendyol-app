package ercanbaris

import org.apache.flink.api.scala._
import org.apache.flink.util.Collector

object TrendyolCaseBatchJob {
  def main(args: Array[String]): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    //val data: DataSet[UserAction] = env.readCsvFile[UserAction](filePath = "src/main/resources/case.csv",fieldDelimiter = "|",ignoreFirstLine = true)
    val data: DataSet[UserAction] = env.readCsvFile[UserAction](filePath = "/trendyol_docker/case.csv",fieldDelimiter = "|",ignoreFirstLine = true)


//    val userWithAllEvents = data.map{ua =>(ua.userId,ua.eventName)}.groupBy(0).reduceGroup {
//      (in, out: Collector[(Int, String)]) =>
//        in.toSet foreach (out.collect)
//    }.map{ua => (ua._1,ua._2,1)}.groupBy(0).sum(2).filter{_._3 == 4}
//    userWithAllEvents.print

  }
}

//.filter{_._1 != 4}
