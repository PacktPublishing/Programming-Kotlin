package com.programming.kotlin.chapter10

import java.util.*

fun maps() {
    val carsMap: Map<String, String> = mapOf("a" to "aston martin", "b" to "bmw", "m" to "mercedes", "f" to "ferrari")
    println("cars[${carsMap.javaClass.canonicalName}:$carsMap]")
    println("car maker starting with 'f':${carsMap.get("f")}")   //ferrari
    println("car maker starting with 'X':${carsMap.get("X")}")  //null

    val customers: java.util.HashMap<Int, Customer> = hashMapOf(
            1 to Customer("Dina", "Kreps", 1),
            2 to Customer("Andy", "Smith", 2)
    )

    val linkedHashMap: java.util.LinkedHashMap<String, String> = linkedMapOf(
            "red" to "#FF0000",
            "azure" to "#F0FFFF",
            "white" to "#FFFFFF"
    )


    val states: MutableMap<String, String> = mutableMapOf("AL" to "Alabama", "AK" to "Alaska", "AZ" to "Arizona")
    states += ("CA" to "California")
    println("States [${states.javaClass.canonicalName}:$states")
    println("States keys:${states.keys}")
    println("States values:${states.values}")

    val sortedMap: SortedMap<Int, String> = sortedMapOf(4 to "d", 1 to "a", 3 to "c", 2 to "b")
    println("Sorted map[${sortedMap.javaClass.canonicalName}]:${sortedMap}")


    CollectionsJ.dangerousCallMap(carsMap.toList().toMap())
    println("Cars:$carsMap")    //a=aston martin, b=bmw, m=mercedes, f=ferrari, newKey!=newValue!

    customers.mapKeys { it.toString() }   // "1" = Customer("Dina","Kreps",1),...
    customers.map { it.key * 10 to it.value.id }         // 10= 1, 20 =2
    customers.mapValues { it.value.lastName }  // 1=Kreps, 2="Smith
    customers.flatMap { (it.value.firstName + it.value.lastName).toSet() }.toSet() //D, i, n, a, K, r, e, p, s, A, d, y, S, m, t, h]
    linkedHashMap.filterKeys { it.contains("r") }  //red=#FF0000,..
    states.filterNot { it.value.startsWith("C") } //AL=Alabama, AK=Alaska, AZ=Arizona

}


data class Customer(val firstName: String, val lastName: String, val id: Int)
