package com.programming.kotlin.chapter03

fun main(args: Array<String>) {

    val e1 = Ellipsis()
    e1.Height = 10
    e1.Width = 12

    val e2 = Ellipsis()
    e2.XLocation = 100
    e2.YLocation = 96
    e1.Height = 21
    e1.Width = 19

    val r1 = Rectangular()
    r1.XLocation = 49
    r1.YLocation = 45
    r1.Width = 10
    r1.Height = 10

    val shapes = listOf<Shape>(e1, e2, r1)

    val selected:Shape? = shapes.firstOrNull { shape ->
        shape.isHit(50, 52)
    }

    if(selected == null){
        println("There is no shape at point(50,52)")
    }else{
        println("A shape of type ${selected.javaClass.simpleName} has been selected.")
    }
}