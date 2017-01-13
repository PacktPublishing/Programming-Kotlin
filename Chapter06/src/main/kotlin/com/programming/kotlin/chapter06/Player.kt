package com.programming.kotlin.chapter06

class Player(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int     by map
    val height: Double by map
}