package com.programming.kotlin.chapter06

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

data class TrivialProperty(private val const: Int) : ReadOnlyProperty<Trivial, Int> {
    override fun getValue(thisRef: Trivial, property: KProperty<*>): Int {
        return const;
    }
}

class Trivial {
    val flag: Int by TrivialProperty(999)
}