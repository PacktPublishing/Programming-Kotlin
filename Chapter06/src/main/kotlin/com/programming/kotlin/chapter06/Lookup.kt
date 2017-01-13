package com.programming.kotlin.chapter06

import java.util.*

class Lookup {
    private var _keywords: HashSet<String>? = null

    val keywords: Iterable<String>
        get() {
            if (_keywords == null) {
                _keywords = HashSet<String>()
            }
            return _keywords ?: throw RuntimeException("Invalid keywords")
        }
}