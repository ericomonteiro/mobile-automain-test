package ericomonteiro.github.com.automain.basics

import ericomonteiro.github.com.automain.config.appium.AppiumProperties
import ericomonteiro.github.com.automain.config.appium.AppiumServer
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.testng.annotations.Test

class AppiumBasics {

    @Test
    fun appiumTest() {
        AppiumServer.service.start()
        val options = UiAutomator2Options()
        options.setDeviceName(AppiumProperties.DEVICE_NAME)
        options.setApp(AppiumProperties.APP)

        val driver = AndroidDriver(AppiumProperties.URL, options)
        driver.quit()
        AppiumServer.service.stop()
    }

}