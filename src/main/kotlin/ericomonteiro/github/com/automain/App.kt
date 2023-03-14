package ericomonteiro.github.com.automain

fun main() {
    println("Hello")

    println()
    println("Properties")
    System.getProperties().forEach {
        println(it)
    }

    println()
    println("env")
    System.getenv().forEach {
        println(it)
    }
}