package com.programming.kotlin.chapter06

import kotlin.reflect.KProperty

class MapDelegate {
   private val map = mutableMapOf<String, Any?>()
    operator fun <T> getValue(ref: Any?, property: KProperty<*>): T {
        return map[property.name] as T
    }

    operator fun <T> setValue(ref: Any?, property: KProperty<*>, value: T?) {
        map.put(property.name, value)
    }
}

data class SomeData(val char: Char)

class PropsByMap() {
    private val mapDelegate = MapDelegate()
    var p1: Int by mapDelegate

    val p2: SomeData by mapDelegate

    init {
        mapDelegate.setValue(this, PropsByMap::p2, SomeData('K'))
        mapDelegate.setValue(this, PropsByMap::p1, 0)
    }
}