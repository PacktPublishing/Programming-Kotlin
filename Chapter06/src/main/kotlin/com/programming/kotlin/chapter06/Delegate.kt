package com.programming.kotlin.chapter06

import org.joda.time.DateTime
import kotlin.reflect.KProperty

interface WithId {
    val id: String
}

data class WithIdImpl(override val id: String) : WithId

class Record(id: String) : WithId by Record.identifier(id) {
    companion object Record {
        fun identifier(identifier: String) = WithIdImpl(identifier)
    }
}

