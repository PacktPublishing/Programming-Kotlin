package com.programming.kotlin.chapter10

fun sets(): Unit {

    val intSet: Set<Int> = setOf(1, 21, 21, 2, 6, 3, 2)                     //1,21,2,6,3
    println("Set of integers[${intSet.javaClass.canonicalName}]:$intSet")


    val books: java.util.HashSet<Book> = hashSetOf(
            Book("Jules Verne", "Around the World in 80 Days Paperback", 2014, "978-1503215153"),
            Book("George R.R. Martin", "Series: Game of Thrones: The Graphic Novel (Book 1)", 2012, "978-0440423218"),
            Book("J.K. Rowling", "Harry Potter And The Goblet Of Fire (Book 4) Hardcover", 2000, "978-0439139595"),
            Book("Jules Verne", "Around the World in 80 Days Paperback", 2014, "978-1503215153")
    )  //Jules Verne,  J.K. Rowling,George R.R. Martin
    println("Set of books:${books}")

    val sortedIntegers: java.util.TreeSet<Int> = sortedSetOf(11, 0, 9, 11, 9, 8)  //0,8,9,11
    println("Sorted set of integer:${sortedIntegers}")

    val charSet: java.util.LinkedHashSet<Char> = linkedSetOf('a', 'x', 'a', 'z', 'a')   //a,x,z
    println("Set of characters:$charSet")

    val longSet: MutableSet<Long> = mutableSetOf(
            20161028141216,
            20161029121211,
            20161029121211
    ) //20161028141216, 20161029121211
    println("Set of longs[${longSet.javaClass.canonicalName}]:$longSet")


    println(intSet.contains(9999))   //false
    println(intSet.contains(1))     //true
    println(books.contains(Book("Jules Verne", "Around the World in 80 Days Paperback", 2014, "978-1503215153"))) //true
    println(intSet.first())          //1
    println(sortedIntegers.last())   // 11
    println(charSet.drop(2))         // z
    println(intSet.plus(10))         // 1,21,2,6,3,10
    println(intSet.minus(21))         // 1,2,6,3
    println(intSet.minus(-1))         // 1,21,2,6,3
    println(intSet.average())         // 6.6
    println(longSet.plus(11))         // 20161028141216, 20161029121211
    println(longSet)                  //20161028141216, 20161029121211


    println(books.map { Pair(it.author, it.title) })    // Jules Verne-Around the World in 80 Days Paperback,...
    println(books
            .flatMap { it.title.asIterable() }
            .toSortedSet())         //[ , (, ), 0, 1, 4, 8, :, A, B, D, F, G, H, N, O, P, S, T, W, a, b, c, d, e, f, h, i, k, l, m, n, o, p, r, s, t, u, v, y]
}


data class Book(val author: String, val title: String, val year: Int, val isbn: String)