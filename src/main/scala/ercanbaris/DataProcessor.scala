package ercanbaris

import org.apache.flink.api.scala._
import org.apache.flink.util.Collector

object DataProcessor {

    def uniqueProductViewByProductId(data : DataSet[(UserAction)]) : DataSet[(Int,Int)] = {
        val processedData: DataSet[(Int,Int)] = data.filter{_.eventName == "view"}.map{ua => (ua.productId,1)}.groupBy(0).sum(1)
        //processedData.print
        processedData
    }

    def uniqueEventCounts(data : DataSet[UserAction]) : DataSet[(String,Int)] = {
        val processedData: DataSet[(String,Int)] = data.map{ua => (ua.eventName,1)}.groupBy(0).sum(1)
        //processedData.print
        processedData
    }

    def topFiveFulfilledAllEvents(data : DataSet[UserAction]) : DataSet[Tuple1[Int]] = {
        val processedData: DataSet[Tuple1[Int]] = data.map{ua =>(ua.userId,ua.eventName,1)}.map{ua => (ua._1,ua._2,1)}.groupBy(0).sum(2).filter{_._3 == 4}.map{ua =>Tuple1(ua._1)}
        //processedData.print
        processedData
    }

    def allEventsOfUser(data : DataSet[UserAction], userId : Int) : DataSet[(String,Int)] = {
        val processedData: DataSet[(String,Int)] = data.filter{_.userId == 47}.map{ua => (ua.eventName,1)}.groupBy(0).sum(1)
        //processedData.print
        processedData
    }

    def productViewsOfUser(data : DataSet[UserAction], userId : Int) : DataSet[Tuple1[Int]] = {
        val processedData: DataSet[Tuple1[Int]] = data.filter{_.userId == 47}.map{ua => Tuple1(ua.productId)}
        //processedData.print
        processedData
    }
}