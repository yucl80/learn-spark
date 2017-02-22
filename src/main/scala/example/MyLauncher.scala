package example

import org.apache.spark.launcher.SparkAppHandle;
import org.apache.spark.launcher.SparkLauncher;
   
object MyLauncher {
  
     def main(args: Array[String]) {
       val  sparkLauncher = new SparkLauncher()
         .setAppResource("E:/spark_workspace/learn-spark/target/learn-spark.jar")
         .setMainClass("org.apache.spark.examples.streaming.NetworkWordCount")
         .setMaster("spark://test.dev.com:7077")
         .setConf(SparkLauncher.DRIVER_MEMORY, "1g")
         .launch();
       sparkLauncher.waitFor();
     }
   }