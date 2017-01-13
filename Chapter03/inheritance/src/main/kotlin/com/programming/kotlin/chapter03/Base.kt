package com.programming.kotlin.chapter03

open class BaseA {
    open val property1: String
        get() = "Base::value"

}

class Derived1 : BaseA() {
    override val property1: String
        get() = "Derived::value"
}

class Derived2(override val property1: String) : BaseA() {}


open class BaseB(open val propertyFoo: String) {
}

class DerivedB : BaseB("") {
    private var _propFoo: String = ""
    override var propertyFoo: String
        get() = _propFoo
        set(value) {
            _propFoo = value
        }
}