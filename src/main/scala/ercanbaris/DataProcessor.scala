package ercanbaris

import org.apache.flink.api.scala._

object DataProcessor {

    def uniqueProductViewByProductId(data : DataSet[(UserAction)]) : DataSet[(Int,Int)] = {
        val processedData: DataSet[(Int,Int)] = data.filter{_.eventName == "view"}.map{ua => (ua.productId,1)}.groupBy(0).sum(1)
        processedData.print
        processedData
    }

    def uniqueEventCounts(data : DataSet[UserAction]) : DataSet[(String,Int)] = {
        val processedData: DataSet[(String,Int)] = data.map{ua => (ua.eventName,1)}.groupBy(0).sum(1)
        processedData.print
        processedData
    }

    def topFiveFulfilledAllEvents(data : DataSet[UserAction]) : DataSet[(Int)] = {
        val processedData: DataSet[(Int)] = null
        processedData.print
        processedData
    }

    def allEventsOfUser(data : DataSet[UserAction], userId : Int) : DataSet[(String,Int)] = {
        val processedData: DataSet[(String,Int)] = data.filter{_.userId == 47}.map{ua => (ua.eventName,1)}.groupBy(0).sum(1)
        processedData.print
        processedData
    }

    def productViewsOfUser(data : DataSet[UserAction], userId : Int) : DataSet[(Int)] = {
        val processedData: DataSet[(Int)] = data.filter{_.userId == 47}.map{ua => (ua.productId)}
        processedData.print
        processedData
    }
}