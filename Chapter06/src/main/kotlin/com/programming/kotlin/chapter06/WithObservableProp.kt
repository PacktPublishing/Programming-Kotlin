package com.programming.kotlin.chapter06

import kotlin.properties.Delegates


class WithObservableProp {
    var value: Int by Delegates.observable(0) { p, oldNew, newVal -> onValueChanged() }

    private fun onValueChanged() {
        println("value has changed:$value")
    }
}


class OnlyPositiveValues {
    var value: Int by Delegates.vetoable(0) { p, oldNew, newVal -> newVal >= 0 }
}
