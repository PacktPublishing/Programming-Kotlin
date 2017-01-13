package com.programming.kotlin.chapter10

fun readonly(){
    val carManufacturers: MutableList<String> = mutableListOf("Masserati", "Aston Martin","McLaren","Ferrari","Koenigsegg")
    val carsView: List<String> = carManufacturers

    carManufacturers.add("Lamborghini")
    println("Cars View:$carsView")
}