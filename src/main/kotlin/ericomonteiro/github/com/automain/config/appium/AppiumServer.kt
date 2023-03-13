package ericomonteiro.github.com.automain.config.appium

import io.appium.java_client.service.local.AppiumDriverLocalService
import io.appium.java_client.service.local.AppiumServiceBuilder
import java.io.File

object AppiumServer {
    val service: AppiumDriverLocalService = AppiumServiceBuilder()
        .withAppiumJS(File(AppiumProperties.SERVER_LOCAL))
        .withIPAddress(AppiumProperties.URL.host)
            .usingPort(AppiumProperties.URL.port)
        .build()
}