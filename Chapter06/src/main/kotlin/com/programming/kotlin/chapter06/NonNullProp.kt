package com.programming.kotlin.chapter06

import kotlin.properties.Delegates


class NonNullProp {
    var value: String by Delegates.notNull<String>()

    var value2:ForProp by Delegates.notNull<ForProp>()
}

data class ForProp(val someField:String)