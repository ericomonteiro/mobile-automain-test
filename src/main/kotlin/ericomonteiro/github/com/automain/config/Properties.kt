package ericomonteiro.github.com.automain.config

import ericomonteiro.github.com.automain.consts.SysProperties
import java.util.Properties

object Properties {

    val values = mutableMapOf<String, String>()

    init {
        loadPropertiesFromFile("application.properties")

        System.getenv(SysProperties.APPIUM_PROFILE)
            ?.split(",")
            ?.forEach { profile ->
                loadPropertiesFromFile("application-$profile.properties")
            }


        System.getenv()
            .filter { envVar -> envVar.key.startsWith("appium") }
            .forEach { envVar -> values[envVar.key.toString()] = envVar.value.toString() }
    }

    private fun loadPropertiesFromFile(file: String) {
        val properties = Properties()
        properties.load(this::class.java.classLoader.getResourceAsStream(file))
        properties.forEach { values[it.key.toString()] = it.value.toString() }
    }
}