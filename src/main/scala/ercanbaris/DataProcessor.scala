package ercanbaris

import org.apache.flink.api.scala._

object DataProcessor {

    def uniqueProductViewByUserId(data : DataSet[UserAction]) : DataSet[UserAction] = {
        val processedData: DataSet[UserAction] = data
        processedData
    }

    def uniqueEventCounts(data : DataSet[UserAction]) : DataSet[UserAction] = {
        val processedData: DataSet[UserAction] = data
        processedData
    }

    def topFiveFulfilledAllEvents(data : DataSet[UserAction]) : DataSet[UserAction] = {
        val processedData: DataSet[UserAction] = data
        processedData
    }

    def allEventsOfUser(data : DataSet[UserAction], userId : Int) : DataSet[UserAction] = {
        val processedData: DataSet[UserAction] = data
        processedData
    }

    def productViewsOfUser(data : DataSet[UserAction], userId : Int) : DataSet[UserAction] = {
        val processedData: DataSet[UserAction] = data
        processedData
    }
}