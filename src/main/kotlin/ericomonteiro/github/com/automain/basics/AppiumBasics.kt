package ericomonteiro.github.com.automain.basics

import ericomonteiro.github.com.automain.config.appium.AppiumDriver
import ericomonteiro.github.com.automain.config.Screen
import ericomonteiro.github.com.automain.config.appium.AppiumProperties
import ericomonteiro.github.com.automain.config.appium.AppiumServer
import ericomonteiro.github.com.automain.consts.Screens
import org.testng.Assert
import org.testng.annotations.Test

class AppiumBasics {

    @Test
    fun appiumTest() {
        val home = Screen(Screens.HOME, AppiumProperties.PLATFORM)
        val preference = Screen(Screens.PREFERENCES, AppiumProperties.PLATFORM)
        val preferenceDependencies = Screen(Screens.PREFERENCE_DEPENDENCIES, AppiumProperties.PLATFORM)

        AppiumServer.startIfNeed()
        val driver = AppiumDriver.start()

        driver.findElement(home.elements["preference"]).click()
        driver.findElement(preference.elements["preference-dependencies"]).click()
        driver.findElement(preferenceDependencies.elements["checkbox"]).click()
        driver.findElement(preferenceDependencies.elements["wifi-settings"]).click()
        driver.findElement(preferenceDependencies.elements["popup-title"]).let {
            popupTittle ->
            Assert.assertEquals(popupTittle.isDisplayed, true, "Pop up is not showed")
            Assert.assertEquals(popupTittle.text, "WiFi settings", "Pop up tittle is incorrect")
        }
        driver.findElement(preferenceDependencies.elements["wifi-edit"]).sendKeys("erico-wifi")
        driver.findElement(preferenceDependencies.elements["confirm-button"]).click()

        driver.quit()
        AppiumServer.stopIfNeed()
    }

}