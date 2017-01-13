package com.programming.kotlin.chapter10

fun indexedAccess():Unit{
    val capitals = listOf("London", "Tokyo", "Instambul", "Bucharest")
    capitals[2]   //Tokyo
    //capitals[100] java.lang.ArrayIndexOutOfBoundException

    val countries = mapOf("BRA" to "Brazil", "ARG" to "Argentina", "ITA" to "Italy")
    countries["BRA"]   //Brazil
    countries["UK"]    //null

}