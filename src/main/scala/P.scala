
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object P {

  case class Person(name: String, age: Long)

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("test").setMaster("local[*]")
    //.setJars(List("E:\\spark_workspace\\learn-spark\\target\\learn-spark.jar"))

    val sc = new SparkContext(conf)
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)
    import sqlContext.implicits._

    val ds = Seq(Person("Andy", 32), Person("lili", 22))

    ds.toDF().write.parquet("/tmp/a2.parquet")

  }
}