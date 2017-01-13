package com.programming.kotlin.chapter06

import kotlin.reflect.KProperty

class TimestampValueDelegate {
    private var timestamp = 0L
    operator fun getValue(ref: Any?, property: KProperty<*>): Long {
        return timestamp;
    }

    operator fun setValue(ref: Any?, property: KProperty<*>, value: Long) {
        timestamp = value
    }
}

class Measure {
    var writeTimestamp: Long by TimestampValueDelegate()
}


