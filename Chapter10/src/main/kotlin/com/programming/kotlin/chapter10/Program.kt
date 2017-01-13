package com.programming.kotlin.chapter10

import java.util.*
import kotlin.reflect.jvm.jvmName

fun main(args: Array<String>): Unit {
    println("Programming Kotlin:Chapter10")

    val jlist = ArrayList<String>()

    jlist.add("sample")
    itWorks(jlist)
    itWorks(Collections.singletonList(1))

    arrays()
    maps()
    sets()
    lists()
    readonly()
    indexedAccess()
    sequences()
}

fun <T> itWorks(list: List<T>): Unit {
    println("Java Class Type:" + list.javaClass.canonicalName)
}