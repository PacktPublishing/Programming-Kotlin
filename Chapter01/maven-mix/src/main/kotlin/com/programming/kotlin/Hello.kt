package com.programming.kotlin

fun main(args: Array<String>) {
    val task = Task(1, "Mix Java and Kotlin code", "Jack Smith")
    println("Task:${task.title}")

    val student = Student("Jenny Wood")
    println("Student:${student.name}")

    val carManufacturer = CarManufacturer("Honda")
    println("Car manufacture:${carManufacturer.name}")
}

