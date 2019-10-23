package com.github.yuxiliu1995.wigner.util

import com.typesafe.config.{Config, ConfigFactory}

/** Provides access to all values in the configuration file. */
object ConfigProvider {
  
  /** Config object containing all configuration values. */
  val globalConfig: Config = ConfigFactory.load()
}
