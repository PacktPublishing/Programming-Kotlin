package com.programming.kotlin.chapter10

import java.util.*

data class Student(val id: Int, val firstName: String, val lastName: String)

fun arrays(): Unit {
    val intArray: Array<Int> = arrayOf(1, 2, 3, 4)
    println("Int array:${intArray.joinToString(",")}")
    println("Element at index 1 is:${intArray[1]}")

    val stringArray = kotlin.arrayOfNulls<String>(3)
    stringArray[0] = "a"
    stringArray[1] = "b"
    stringArray[2] = "c"
    //stringArrays[3]="d" --throws index out of bounds exception
    println("String array:${stringArray.joinToString(",")}")

    val studentArray = Array<Student>(2) { index ->
        when (index) {
            0 -> Student(1, "Alexandra", "Brook")
            1 -> Student(2, "James", "Smith")
            else -> throw IllegalArgumentException("Too many")
        }
    }
    println("Student array:${studentArray.joinToString(",")}")
    println("Student at index 0:${studentArray[0]}")


    val longArray = emptyArray<Long>()
    println("Long array:${longArray.joinToString(",")}")


    val ints: IntArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("Built in int array:${ints.joinToString(",")}")


    val countries = arrayOf("UK", "Germany", "Italy")
    for (country in countries) {
        print("$country;")
    }

    val numbers = intArrayOf(10, 20, 30)
    for (i in numbers.indices) {
        numbers[i] *= 10
    }

    val index = Random().nextInt(10)
    if (index in numbers.indices) {
        numbers[index] = index
    }

    println("First element in the IntArray:${ints.first()}")
    println("Last element in the IntArray:${ints.last()}")
    println("Take first 3 elements of the IntArray:${ints.take(3).joinToString(",")}")
    println("Take last 3 elements of the IntArray:${ints.takeLast(3).joinToString(",")}")
    println("Take elements smaller than 500 of the IntArray:${ints.takeWhile { it < 500 }.joinToString(",")}")
    println("Take every 3rd element in IntArray: ${ints.filterIndexed { index, element -> index % 3 == 0 }.joinToString(",")}")

    val strings = ints.map { element -> "Item " + element.toString() }
    println("Transform each element IntArray into a string:${strings.joinToString(",")}")

    val charArray = charArrayOf('a', 'b', 'c')
    val tripleCharArray = charArray.flatMap { c -> charArrayOf(c, c, c).asIterable() }
    println("Triple each element in the charArray:${tripleCharArray.joinToString(",")}}")

    val longs = longArrayOf(1, 2, 1, 2, 3, 4, 5)
    val hashSet: HashSet<Long> = longs.toHashSet()
    println("Java HashSet:${hashSet.joinToString(",")}")
    val sortedSet: SortedSet<Long> = longs.toSortedSet()
    println("Sorted Set[${sortedSet.javaClass.canonicalName}]:${sortedSet.joinToString(",")}")
    val set: Set<Long> = longs.toSet()
    println("Set[${set.javaClass.canonicalName}]:${set.joinToString(",")}")
    val mutableSet = longs.toMutableSet()
    mutableSet.add(10)
    println("MutableSet[${mutableSet.javaClass.canonicalName}]:${mutableSet.joinToString(",")}")
    val list: List<Long> = longs.toList()
    println("List[${list.javaClass.canonicalName}]:${list.joinToString(",")}")
    val mutableList: MutableList<Long> = longs.toMutableList()
    println("MutableList[${mutableList.javaClass.canonicalName}]:${mutableList.joinToString(",")}")

    val hackedList = (list as ArrayList<Long>)
    hackedList.add(100)
    println("List[${list.javaClass.canonicalName}]:${list.joinToString(",")}")

    val integers = intArrayOf(1, 2, 3, 4, 5, 6)
    val (i1, i2, i3, i4, i5) = integers
    println("i1:$i1; i2:$i2;..;i5=$i5")


}