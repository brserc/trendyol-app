package ercanbaris

import org.scalatest.FunSpec
import org.apache.flink.api.scala._

class DataProcessorSpec extends FunSpec {

    val row1 : UserAction = UserAction(1535816823,7,"view",7)
    val row2 : UserAction = UserAction(1535816824,7,"add",7)
    val row3 : UserAction = UserAction(1535816825,5,"remove",7)
    val row4 : UserAction = UserAction(1535816826,12,"click",7)
    val row5 : UserAction = UserAction(1535816827,5,"view",7)
    val row6 : UserAction = UserAction(1535816828,7,"view",6)
    val row7 : UserAction = UserAction(1535816829,4,"view",7)
    val row8 : UserAction = UserAction(1535816830,7,"click",9)
    val row9 : UserAction = UserAction(1535816831,5,"view",1)

    val env = ExecutionEnvironment.getExecutionEnvironment
    val testDataEmpty: DataSet[UserAction] = env.fromElements()
    val testData1: DataSet[UserAction]   = env.fromElements(row1,row2,row3,row4,row5,row6,row7,row8,row9);


    describe("DataProcessor::all") {
        it("should handle empty input"){
            val expectedProductViewByProductId: DataSet[(Int,Int)] = env.fromElements()
            val expectedUniqueEventCounts: DataSet[(String,Int)] = env.fromElements()
            val expectedTopFiveFulfilledAllEvents: DataSet[(Int)] = env.fromElements()
            val expectedAllEventsOfUser: DataSet[(String,Int)] = env.fromElements()
            val expectedProductViewsOfUser: DataSet[(Int)] = env.fromElements()

            assert(DataProcessor.uniqueProductViewByProductId(testDataEmpty).collect().equals(expectedProductViewByProductId.collect()))
            assert(DataProcessor.uniqueEventCounts(testDataEmpty).collect().equals(expectedUniqueEventCounts.collect()))
            assert(DataProcessor.topFiveFulfilledAllEvents(testDataEmpty).collect().equals(expectedTopFiveFulfilledAllEvents.collect()))
            assert(DataProcessor.allEventsOfUser(testDataEmpty,7).collect().equals(expectedAllEventsOfUser.collect()))
            assert(DataProcessor.productViewsOfUser(testDataEmpty,7).collect().equals(expectedProductViewsOfUser.collect()))
        }
        
    }

    describe("DataProcessor::uniqueProductViewByProductId") {
        it("should handle testdata1"){
            val expectedProductViewByProductId: DataSet[(Int,Int)] = env.fromElements((7,2),(5,2),(4,1))
            expectedProductViewByProductId.print
            assert(DataProcessor.uniqueProductViewByProductId(testData1).collect().equals(expectedProductViewByProductId.collect()))
        }
    }

    describe("DataProcessor::uniqueEventCounts") {
        it("should handle testdata1"){
            val expectedUniqueEventCounts: DataSet[(String,Int)] = env.fromElements(("view",5),("add",1),("remove",1),("click",2))
            assert(DataProcessor.uniqueEventCounts(testData1).collect().equals(expectedUniqueEventCounts.collect()))        
        }
    }

    describe("DataProcessor::topFiveFulfilledAllEvents") {
        it("should handle testdata1"){
            val expectedTopFiveFulfilledAllEvents: DataSet[(Int)] = env.fromElements((7))
            assert(DataProcessor.topFiveFulfilledAllEvents(testData1.collect()).equals(expectedTopFiveFulfilledAllEvents.collect()))        
        }        
    }

    describe("DataProcessor::allEventsOfUser") {
        it("should handle testdata1"){
            val expectedAllEventsOfUser: DataSet[(String,Int)] = env.fromElements(("view",1))
            assert(DataProcessor.allEventsOfUser(testData1,6).collect().equals(expectedAllEventsOfUser.collect()))        
        }        
    }

    describe("DataProcessor::productViewsOfUser") {
        it("should handle testdata1"){
            val expectedProductViewsOfUser: DataSet[(Int)] = env.fromElements((7))
            assert(DataProcessor.productViewsOfUser(testData1,6).collect().equals(expectedProductViewsOfUser.collect()))        
        }       
    }

}