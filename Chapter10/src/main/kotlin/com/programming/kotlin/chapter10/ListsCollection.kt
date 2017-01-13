package com.programming.kotlin.chapter10

import java.math.BigDecimal
import java.util.*

fun lists(): Unit {

    val intList: List<Int> = listOf<Int>(20, 29, 40, 10)
    println("Int list[${intList.javaClass.canonicalName}]:${intList.joinToString(",")}")

    val emptyList: List<String> = emptyList<String>()
    println("Empty list[${emptyList.javaClass.canonicalName}]:${emptyList.joinToString(",")}")

    val nonNulls: List<String> = listOfNotNull<String>(null, "a", "b", "c")
    println("Non-Null string lists[${nonNulls.javaClass.canonicalName}]:${nonNulls.joinToString(",")}")

    val doubleList: ArrayList<Double> = arrayListOf(84.88, 100.25, 999.99)
    println("Double list:${doubleList.joinToString(",")}")


    val cartoonsList: MutableList<String> = mutableListOf("Tom&Jerry", "Dexter's Laboratory", "Johnny Bravo", "Cow&Chicken")
    println("Cartoons list[${cartoonsList.javaClass.canonicalName}]: ${cartoonsList.joinToString(",")}")

    cartoonsList.addAll(arrayOf("Ed, Edd n Eddy", "Courage the Cowardly Dog"))
    println("Cartoons list[${cartoonsList.javaClass.canonicalName}]: ${cartoonsList.joinToString(",")}")

    (intList as AbstractList<Int>).set(0, 999999)
    println("Int list[${intList.javaClass.canonicalName}]:${intList.joinToString(",")}")

    (nonNulls as java.util.ArrayList).addAll(arrayOf("x", "y"))
    println("countries list[${nonNulls.javaClass.canonicalName}]:${nonNulls.joinToString(",")}")

    val hacked: List<Int> = listOfNotNull(0, 1)
    CollectionsJ.dangerousCall(hacked)
    println("Hacked list[${hacked.javaClass.canonicalName}]:${hacked.joinToString(",")}")


    val planets = listOf(
            Planet("Mercury", 57910000),
            Planet("Venus", 108200000),
            Planet("Earth", 149600000),
            Planet("Mars", 227940000),
            Planet("Jupiter", 778330000),
            Planet("Saturn", 1424600000),
            Planet("Uranus", 2873550000),
            Planet("Neptune", 4501000000),
            Planet("Pluto", 5945900000)
    )

    println(planets.last())          //Pluto
    println(planets.first())         //Mercury
    println(planets.get(4))          //Jupiter
    println(planets.isEmpty())       // false
    println(planets.isNotEmpty())    //true

    println(planets.asReversed())        //"Pluto", "Neptune"
    println(planets.elementAtOrNull(10)) //Null

    planets.zip(arrayOf(4800, 12100, 12750, 6800, 142800, 120660, 51800, 49500, 3300))
            .forEach {
                val (planet, diameter) = it
                println("${planet.name}'s diameter is $diameter km")
            }

    val reversePlanetName = planets.foldRight(StringBuilder()) { planet, builder ->
        builder.append(planet.name)
        builder.append(";")
    }
    println(reversePlanetName)          //Pluto, Neptune..Earth;Venus;Mercury

    val amount = listOf(
            ShoppingItem("1", "Intel i7-950 Quad-Core Processor", BigDecimal("319.76"), 1),
            ShoppingItem("2", "Samsung 750 EVO 250 GB 2.5 inch SDD", BigDecimal("71.21"), 1)
    ).foldRight(BigDecimal.ZERO) { item, total ->
        total + BigDecimal(item.quantity) * item.price
    }
    println(amount)   //390.97

    println(planets.map { it.distance })   //List(57910000, ...,5945900000)

    val list = listOf(listOf(10, 20), listOf(14, 18), emptyList())
    val increment = { x: Int -> x + 1 }
    list.flatMap { it.map(increment) }   //11,21,15,10

    val chars = listOf('a', 'd', 'c', 'd', 'a')
    val (c1,c2,c3,c4,c5) = chars
    println("$c1$c2$c3$c4$c5")

    val array: Array<Char> = chars.toTypedArray()
    val arrayBetter: CharArray = chars.toCharArray()
    val set: Set<Char> = chars.toSet()
    println(set)
    val charsMutable = chars.toMutableList()
}


data class Planet(val name: String, val distance: Long)

data class ShoppingItem(val id: String, val name: String, val price: BigDecimal, val quantity: Int)