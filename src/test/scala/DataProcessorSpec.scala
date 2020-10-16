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
            assert(DataProcessor.uniqueProductViewByUserId(testDataEmpty) == 0)
            assert(DataProcessor.uniqueEventCounts(testDataEmpty) == 0)
            assert(DataProcessor.topFiveFulfilledAllEvents(testDataEmpty) == 0)
            assert(DataProcessor.allEventsOfUser(testDataEmpty) == 0)
            assert(DataProcessor.productViewsOfUser(testDataEmpty) == 0)
        }
        
    }

     escribe("DataProcessor::uniqueProductViewByUserId") {
        
    }

    describe("DataProcessor::uniqueEventCounts") {
        
    }

    describe("DataProcessor::topFiveFulfilledAllEvents") {
        
    }

    describe("DataProcessor::allEventsOfUser") {
        
    }

    describe("DataProcessor::productViewsOfUser") {
        
    }

}