package ericomonteiro.github.com.automain.basics

import com.google.common.collect.ImmutableMap
import ericomonteiro.github.com.automain.config.Screen
import ericomonteiro.github.com.automain.config.appium.AppiumDriver
import ericomonteiro.github.com.automain.config.appium.AppiumServer
import ericomonteiro.github.com.automain.consts.Screens
import ericomonteiro.github.com.automain.consts.Scripts
import ericomonteiro.github.com.automain.extensions.toGestureElementMap
import ericomonteiro.github.com.automain.extensions.toRemoteWebElement
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.ScriptKey
import org.openqa.selenium.remote.RemoteWebElement
import org.testng.annotations.Test
import org.testng.internal.ScriptSelectorFactory


class AppiumLongTap {

    @Test
    fun appiumGestureLongTap() {
        val home = Screen(Screens.HOME)
        val views = Screen(Screens.VIEWS)
        val expandableLists = Screen(Screens.EXPANDABLE_LISTS)
        val customAdapter = Screen(Screens.CUSTOM_ADAPTER)

        AppiumServer.startIfNeed()
        val driver = AppiumDriver.start()

        driver.findElement(home.elements["views"]).click()

        val list = driver.findElement(views.elements["list"])
        driver.executeScript(Scripts.SCROLL_GESTURE,
                list.toGestureElementMap().apply {
                    this["left"] = "100"
                    this["top"] = "100"
                    this["width"] = "200"
                    this["height"] = "200"
                    this["direction"] = "down"
                    this["percent"] = "0.5"
                    this["speed"] = "300"
                }
            )

        driver.findElement(views.elements["expandable-lists"]).click()
        driver.findElement(expandableLists.elements["custom-adapter"]).click()

        val peopleNames = driver.findElement(customAdapter.elements["people-names"])
        driver.executeScript("mobile: longClickGesture",
                peopleNames.toGestureElementMap().apply { this["duration"] = "2000" }
            )
    }

}