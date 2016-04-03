/* SimpleApp.scala */
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import java.math.BigInteger

object SimpleApp {
  def main(args: Array[String]) {
    val logFile = "/user/zhuotao/kenshoo/tsel-pixel-final-graph-ver2" // Should be some file on your system
    val conf = new SparkConf().setAppName("test")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val bigInteger = new BigInteger("234523423462346", 10)
    val numAs = logData.filter(line => line.contains("Android")).count()
    val numBs = logData.filter(line => line.contains("iOS")).count()
    println("Lines with android: %s, Lines with ios: %s".format(numAs, numBs))
  }
}
