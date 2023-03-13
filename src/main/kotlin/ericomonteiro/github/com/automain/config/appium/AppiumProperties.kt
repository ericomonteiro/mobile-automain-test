package ericomonteiro.github.com.automain.config.appium

import ericomonteiro.github.com.automain.config.Properties
import java.net.URL

object AppiumProperties {
    val URL: URL = URL(Properties.values["appium.url"])
    val APP: String = Properties.values["appium.app"]!!
    val DEVICE_NAME: String = Properties.values["appium.device-name"]!!
    val SERVER_LOCAL: String = Properties.values["appium.server-location"]!!
}