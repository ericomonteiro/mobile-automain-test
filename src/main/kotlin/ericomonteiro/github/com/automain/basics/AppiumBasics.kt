package ericomonteiro.github.com.automain.basics

import ericomonteiro.github.com.automain.config.appium.AppiumDriver
import ericomonteiro.github.com.automain.config.Screen
import ericomonteiro.github.com.automain.config.appium.AppiumProperties
import ericomonteiro.github.com.automain.config.appium.AppiumServer
import ericomonteiro.github.com.automain.consts.Platforms
import ericomonteiro.github.com.automain.consts.Screens
import org.testng.annotations.Test

class AppiumBasics {

    @Test
    fun appiumTest() {
        val home = Screen(Screens.HOME, AppiumProperties.PLATFORM)
        val preference = Screen(Screens.PREFERENCES, AppiumProperties.PLATFORM)
        val preferenceDependencies = Screen(Screens.PREFERENCE_DEPENDENCIES, AppiumProperties.PLATFORM)

        AppiumServer.service.start()
        val driver = AppiumDriver.start()

        driver.findElement(home.elements["preference"]).click()
        driver.findElement(preference.elements["preference-dependencies"]).click()
        driver.findElement(preferenceDependencies.elements["checkbox"]).click()

        driver.quit()
        AppiumServer.service.stop()
    }

}