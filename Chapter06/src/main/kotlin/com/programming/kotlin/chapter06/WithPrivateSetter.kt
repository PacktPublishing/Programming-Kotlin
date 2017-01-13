package com.programming.kotlin.chapter06

import java.util.*

class WithPrivateSetter(property: Int) {
    var SomeProperty: Int = 0
        private set(value) {
            field = value
        }

    init {
        SomeProperty = property
    }
}