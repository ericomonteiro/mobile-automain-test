package ericomonteiro.github.com.automain.config

import ericomonteiro.github.com.automain.config.appium.AppiumProperties
import ericomonteiro.github.com.automain.consts.ByKinds
import io.appium.java_client.AppiumBy
import org.openqa.selenium.By
import java.util.Properties

class Screen(
    private val screen: String,
    private val platform: String
) {

    constructor(screen: String): this(screen, AppiumProperties.PLATFORM)

    private val properties = Properties()
    val elements = mutableMapOf<String, By>()

    init {
        val file = this::class.java.classLoader.getResourceAsStream(getFile())
        properties.load(file)
        properties.forEach { property ->
            val propertySplit = property.key.toString().split(".")
            val element = propertySplit[2]
            val value: By = propertySplit.last().let {by ->
                when (by) {
                    ByKinds.ACCESSIBILITY_ID -> AppiumBy.ByAccessibilityId(property.value.toString())
                    ByKinds.ID -> By.id(property.value.toString())
                    ByKinds.XPATH -> By.xpath(property.value.toString())
                    else -> By.id(property.value.toString())
                }

            }
            elements[element] = value
        }
    }

    private fun getFile() =
            "screens/$platform/$screen.properties"

}