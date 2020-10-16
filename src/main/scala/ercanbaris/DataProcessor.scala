package ercanbaris

import org.apache.flink.api.scala._

object DataProcessor {

    def uniqueProductViewByUserId(data : DataSet[(UserAction)]) : DataSet[(Int,Int)] = {
        val processedData: DataSet[(Int,Int)] = null
        processedData
    }

    def uniqueEventCounts(data : DataSet[UserAction]) : DataSet[(String,Int)] = {
        val processedData: DataSet[(String,Int)] = null
        processedData
    }

    def topFiveFulfilledAllEvents(data : DataSet[UserAction]) : DataSet[(Int)] = {
        val processedData: DataSet[(Int)] = null
        processedData
    }

    def allEventsOfUser(data : DataSet[UserAction], userId : Int) : DataSet[(String,Int)] = {
        val processedData: DataSet[(String,Int)] = null
        processedData
    }

    def productViewsOfUser(data : DataSet[UserAction], userId : Int) : DataSet[(Int)] = {
        val processedData: DataSet[(Int)] = null
        processedData
    }
}