package ericomonteiro.github.com.automain.config.appium

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options

class AppiumDriver {

    companion object {

        fun start(): AndroidDriver {
            val options = UiAutomator2Options()
            options.setDeviceName(AppiumProperties.DEVICE_NAME)
            options.setApp(AppiumProperties.APP)
            return AndroidDriver(AppiumProperties.URL, options)
        }


    }

}