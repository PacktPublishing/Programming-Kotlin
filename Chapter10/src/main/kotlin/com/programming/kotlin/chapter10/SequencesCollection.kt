package com.programming.kotlin.chapter10

import java.io.BufferedReader
import java.io.InputStreamReader

fun sequences(): Unit {

    val charSequence: Sequence<Char> = charArrayOf('a', 'b', 'c').asSequence()  //a,b,c
    println("Char sequence:[${charSequence.javaClass.canonicalName}]:${charSequence.joinToString(",")}")
    println("Char sequence:[${charSequence.javaClass.name}]:${charSequence.joinToString(",")}")


    val longsSequence: Sequence<Long> = listOf(12000L, 11L, -1999L).asSequence()  // 1200,11,-1999
    println("Long sequence:[${longsSequence.javaClass.canonicalName}]:${longsSequence.joinToString(",")}")
    println("Long sequence:[${longsSequence.javaClass.name}]:${longsSequence.joinToString(",")}")

    val mapSequence: Sequence<Map.Entry<Int, String>> = mapOf(1 to "A", 2 to "B", 3 to "C").asSequence() //1=A,2=B,3=C
    println("Long sequence:[${mapSequence.javaClass.canonicalName}]:${mapSequence.joinToString(",")}")
    println("Long sequence:[${mapSequence.javaClass.name}]:${mapSequence.joinToString(",")}")


    val setSequence: Sequence<String> = setOf("Anna", "Andrew", "Jack", "Laura", "Anna").asSequence()
    println("String sequence:[${setSequence.javaClass.canonicalName}]:${setSequence.joinToString(",")}")  //Anna, Andrew,Jack, Laura


    val intSeq = sequenceOf(1, 2, 3, 4, 5)
    println("Sequence of integers[${intSeq.javaClass.canonicalName}]:$intSeq")

    val emptySeq: Sequence<Int> = emptySequence<Int>()
    println("Empty sequence[${emptySeq.javaClass.canonicalName}]:$emptySeq")

    var nextItem = 0
    val sequence = generateSequence {
        nextItem += 1
        nextItem
    }
//    sequence.joinToString(",") -> don't! Out of memory will be thrown
    println("Unbound int sequence[${sequence.javaClass.canonicalName}]:${sequence.takeWhile { it < 100 }.joinToString(",")}") //1,2,3...99

//    println("Unbound int sequence[${sequence.javaClass.canonicalName}]:${sequence.takeWhile { it < 100 }.joinToString(",")}") //java.lang.IllegalStateException: This sequence can be consumed only once.

    val secondSequence = generateSequence(100) { if ((it + 1) % 2 == 0) it + 1 else it + 2 }

    println("Unbound int sequence[${secondSequence.javaClass.canonicalName}]:${secondSequence.takeWhile { it < 110 }.toList()}") //100, 102, 104, 106, 108]

    val stream = Thread.currentThread().javaClass.getResourceAsStream("/afile.txt");
    val br = BufferedReader(InputStreamReader(stream));
    val fileContent = generateSequence { br.readLine() }.takeWhile { it != null }
    println("File content:${fileContent.joinToString(" ")}")

    var prevNumber: Int = 0
    val fibonacci1 = generateSequence(1) {
        val tmp = prevNumber
        prevNumber = it
        it + tmp
    }
    println("Fibonacci sequence: ${fibonacci1.take(12).joinToString(",")}")

    val fibonacci2 = generateSequence(1 to 1) {
        it.second to it.first + it.second
    }.map { it.first }
    println("Fibonacci sequence: ${fibonacci2.take(12).joinToString(",")}")

    println("Fibonacci sequence: ${fibonacci2.take(12).joinToString(",")}")
}