package com.programming.kotlin.chapter06

open class WithInheritance {
    open var isAvailable: Boolean = false
        get() = field
        protected set(value) {
            field = value
        }
}

class WithInheritanceDerived(isAvailable: Boolean) : WithInheritance() {
    override var isAvailable: Boolean = isAvailable
        get() {
            //do something before returning the value
            return super.isAvailable
        }
        set(value) {
            //do something else before setting the value
            println("WithInhertianceDerived.isAvailable")
            field = value
        }

    fun doSomething() {
        isAvailable = false
    }
}