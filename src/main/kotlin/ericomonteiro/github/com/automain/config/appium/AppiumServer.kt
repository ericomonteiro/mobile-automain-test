package ericomonteiro.github.com.automain.config.appium

import io.appium.java_client.service.local.AppiumDriverLocalService
import io.appium.java_client.service.local.AppiumServiceBuilder
import java.io.File

object AppiumServer {
    private val embedded: Boolean = AppiumProperties.EMBEDDED
    private val service: AppiumDriverLocalService? =
        if (embedded)
            AppiumServiceBuilder()
            .withAppiumJS(File(AppiumProperties.SERVER_LOCAL))
            .withIPAddress(AppiumProperties.URL.host)
                .usingPort(AppiumProperties.URL.port)
            .build() else null

    fun startIfNeed() {
        if (service != null && embedded && !service.isRunning) {
            service.start()
        }
    }

    fun stopIfNeed() {
        if (service != null && service.isRunning) {
            service.stop()
        }
    }
}