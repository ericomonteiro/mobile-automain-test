package ericomonteiro.github.com.automain.extensions

import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebElement

fun WebElement.toRemoteWebElement() = this as RemoteWebElement

fun WebElement.toGestureElementMap(): MutableMap<String, String> =
    mutableMapOf(Pair("elementId", this.toRemoteWebElement().id))