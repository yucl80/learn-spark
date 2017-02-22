

import com.typesafe.config.ConfigFactory

object Config {
  val envName = "LOG_ANALYSIS_ENV"
  val envValue = if (System.getenv(envName) == null) "production" else System.getenv(envName)
  val conf = ConfigFactory.load()
  def apply() = conf.getConfig(envValue)
}