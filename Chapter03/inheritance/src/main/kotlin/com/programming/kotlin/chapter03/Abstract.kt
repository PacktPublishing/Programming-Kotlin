package com.programming.kotlin.chapter03

import java.util.*

open class AParent protected constructor() {
    open fun someMethod(): Int = Random().nextInt()
}

abstract class DDerived : AParent() {
    abstract override fun someMethod(): Int
}

class AlwaysOne : DDerived() {
    override fun someMethod(): Int {
        return 1
    }
}