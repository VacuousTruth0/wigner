package com.github.yuxiliu1995.wigner.poincare.util

import com.github.yuxiliu1995.wigner.util.ConfigProvider.globalConfig
import com.typesafe.config.Config

/** Provides access to values in the configuration file for this package. */
object ConfigProvider {
  
  /** Config object containing all configuration values for this package. */
  val config: Config = globalConfig.getConfig("poincare")
}
