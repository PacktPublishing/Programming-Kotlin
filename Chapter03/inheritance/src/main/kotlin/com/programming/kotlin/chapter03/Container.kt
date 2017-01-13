package com.programming.kotlin.chapter03

open class Container {
    protected open val fieldA: String = "Some value"
}

class DerivedContainer : Container() {
    public override val fieldA: String = "Something else"
}