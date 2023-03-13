package ericomonteiro.github.com.automain.config

import java.util.Properties

object Properties {

    val values = mutableMapOf<String, String>()

    init {
        val properties = Properties()
        properties.load(this::class.java.classLoader.getResourceAsStream("application.properties"))
        properties.forEach { values[it.key.toString()] = it.value.toString() }
    }
}