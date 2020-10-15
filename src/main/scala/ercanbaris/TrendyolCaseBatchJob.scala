package ercanbaris

import org.apache.flink.api.scala._
import org.apache.flink.util.Collector

object TrendyolCaseBatchJob {
  def main(args: Array[String]): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    //val data: DataSet[UserAction] = env.readCsvFile[UserAction](filePath = "src/main/resources/case.csv",fieldDelimiter = "|",ignoreFirstLine = true)
    val data: DataSet[UserAction] = env.readCsvFile[UserAction](filePath = "/trendyol_docker/case.csv",fieldDelimiter = "|",ignoreFirstLine = true)
    val distinctproduct = data.filter{_.eventName == "view"}.map{ua => (ua.productId,1)}.groupBy(0).sum(1)
    distinctproduct.print

    val uniqueevents = data.map{ua => (ua.eventName,1)}.groupBy(0).sum(1)
    uniqueevents.print

//    val userWithAllEvents = data.map{ua =>(ua.userId,ua.eventName)}.groupBy(0).reduceGroup {
//      (in, out: Collector[(Int, String)]) =>
//        in.toSet foreach (out.collect)
//    }.map{ua => (ua._1,ua._2,1)}.groupBy(0).sum(2).filter{_._3 == 4}
//    userWithAllEvents.print

    val allEventsUserId = data.filter{_.userId == 47}.map{ua => (ua.eventName,1)}.groupBy(0).sum(1)
    allEventsUserId.print

    val productViewsUserId = data.filter{_.userId == 47}.map{ua => (ua.productId)}
    productViewsUserId.print
  }
}

//.filter{_._1 != 4}
