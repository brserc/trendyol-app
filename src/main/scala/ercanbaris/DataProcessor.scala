package ercanbaris

import org.apache.flink.api.scala._
import org.apache.flink.util.Collector
import org.apache.flink.api.common.operators.Order

object DataProcessor {

    def uniqueProductViewByProductId(data : DataSet[(UserAction)]) : DataSet[(Int,Int)] = {
        val processedData: DataSet[(Int,Int)] = data.filter{_.eventName == "view"}
                                                             .map{ua => (ua.productId,1)}
                                                             .groupBy(0)
                                                             .sum(1)
        //processedData.print
        processedData
    }

    def uniqueEventCounts(data : DataSet[UserAction]) : DataSet[(String,Int)] = {
        val processedData: DataSet[(String,Int)] = data.map{ua => (ua.eventName,1)}
                                                       .groupBy(0)
                                                       .sum(1)
        //processedData.print
        processedData
    }

    def topFiveFulfilledAllEvents(data : DataSet[UserAction]) : DataSet[Tuple1[Int]] = {
        val processedData: DataSet[Tuple1[Int]] = data.map{ua => (ua.userId,Set(ua.eventName))}
                                                      .groupBy(0)
                                                      .reduce{(a:(Int,Set[String]),b:(Int,Set[String]))=>(a._1,a._2++b._2)}
                                                      .filter{_._2.size == 4}
                                                      .map{a => Tuple1(a._1)}
                                                      .sortPartition(0, Order.DESCENDING).first(5)
    
        processedData
    }

    def allEventsOfUser(data : DataSet[UserAction], userId : Int) : DataSet[(String,Int)] = {
        val processedData: DataSet[(String,Int)] = data.filter{_.userId == userId}
                                                   .map{ua => (ua.eventName,1)}
                                                   .groupBy(0).sum(1)
        //processedData.print
        processedData
    }

    def productViewsOfUser(data : DataSet[UserAction], userId : Int) : DataSet[Tuple1[Int]] = {
        val processedData: DataSet[Tuple1[Int]] = data.filter{_.userId == userId}
                                                      .map{ua => Tuple1(ua.productId)}
        //processedData.print
        processedData
    }
}