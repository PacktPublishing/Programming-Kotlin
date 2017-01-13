package com.programming.kotlin.chapter09

import org.joda.time.DateTime
import java.net.URI

fun main(args: Array<String>) {
    val blogEntry = BlogEntry("Data Classes are here",
            "Because Kotlin rulz!",
            DateTime.now(),
            true,
            DateTime.now(),
            URI("http://packt.com/blog/programming_kotlin/data_classes"),
            0,
            emptyList(),
            null)

    println(blogEntry)

    blogEntry.copy(title = "Properties in Kotlin",
            description = "Properties are awesome in Kotlin")


    val (title, description, publishTime,
            approved, lastUpdated, url, comments, tags, email) = blogEntry

    println("""Here are the values for each field in the entry:
            title=$title
            description=$description
            publishTime=$publishTime
            approved=$approved
            lastUpdated=$lastUpdated
            url=$url
            comments=$comments
            tags=$tags,
            email=$email""")


    val countriesAndCaptial = listOf(
            Pair("UK", "London"),
            Pair("France", "Paris"),
            Pair("Australia", "Canberra")
    )
    for ((country, capital) in countriesAndCaptial) {
        println("The capital of $country is $capital")
    }

    val colours = listOf(
            Triple("#ff0000", "rgb(255, 0, 0)", "hsl(0, 100%, 50%)"),
            Triple("#ff4000", "rgb(255, 64, 0)", "hsl(15, 100%, 50%)")
    )

    for((hex, rgb, hsl) in colours){
        println("hex=$hex; rgb=$rgb; hsl=$hsl")
    }

    for ((x,y,z) in listOf(Vector3(0.2,0.1,0.5), Vector3(-12.0, 3.145, 5.100))){
        println("Coordinates: x=$x, y=$y, z=$z")
    }


    for((sensorId, value) in listOf(Sensor("DS18B20", 29.2), Sensor("DS18B21", 32.1))){
        println("Sensor $sensorId reading is $value degrees Celsius")
    }
}

