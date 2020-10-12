package ercanbaris

import org.apache.flink.api.scala._
import java.nio.file.Paths
object TrendyolCaseBatchJob {
  def main(args: Array[String]): Unit = {
    // set up the execution environment
    println(Paths.get(".").toAbsolutePath)

    val env = ExecutionEnvironment.getExecutionEnvironment
    val lines = env.readCsvFile[(Integer, Integer, String, Integer)](filePath = "./src/main/resources/case.csv",fieldDelimiter = "|",ignoreFirstLine = true)
    lines.print
    /**
     * Here, you can start creating your execution plan for Flink.
     *
     * Start with getting some data from the environment, like
     * env.readTextFile(textPath);
     *
     * then, transform the resulting DataSet[String] using operations
     * like:
     *   .filter()
     *   .flatMap()
     *   .join()
     *   .group()
     *
     * and many more.
     * Have a look at the programming guide:
     *
     * http://flink.apache.org/docs/latest/programming_guide.html
     *
     * and the examples
     *
     * http://flink.apache.org/docs/latest/examples.html
     *
     */


    // execute program
    // env.execute("Flink Scala API Skeleton")
  }
}
