package com.programming.kotlin.chapter03

import java.io.ByteArrayOutputStream
import java.lang.reflect.Modifier
import java.math.BigDecimal

fun main(args: Array<String>) {
    val cheque = ChequePayment(BigDecimal(1000), "Alex Woods", "BANK123")
    println(cheque)

    val derivedContainer = DerivedContainer()
    println("DerivedContainer.fieldA:${derivedContainer.fieldA}")

    /*
    val container:Container = derivedContainer
    println("fieldA:${container.fieldA}")
    */

    derivedContainer.javaClass.superclass.getDeclaredFields().forEach { field ->
        field.setAccessible(true)
        println("Field:${field.name},${Modifier.toString(field.modifiers)}, Value=${field.get(derivedContainer)}")

    }
    derivedContainer.javaClass.getDeclaredFields().forEach { field ->
        field.setAccessible(true)
        println("Field:${field.name},${Modifier.toString(field.modifiers)}, Value=${field.get(derivedContainer)}")
    }


    val cesna = CesanaAirplane()
    cesna.fly()

    val d1: BaseA = Derived1()
    val d2: BaseA = Derived2("My value for Derived2")
    println("Derived1: ${d1.property1}")
    println("Derived2: ${d2.property1}")

    val baseB = BaseB("BaseB:value")
    val derivedB = DerivedB()
    derivedB.propertyFoo = "on the spot value"
    println("BaseB:${baseB.propertyFoo}")
    println("DerivedB:${derivedB.propertyFoo}")


    val pngImage = PNGImage()
    val os = ByteArrayOutputStream()
    pngImage.save(os)

    println("First lettter:" + showFirstCharacter("Kotlin is cool"))

    Singleton.doSomething()

    Singleton.doSomething()

    SingletonDerive.something()

    Student.create("Jack Wallace")

    val tree = IntBinaryTree.IntBinaryTreeNode(
            IntBinaryTree.IntBinaryTreeNode(
                    IntBinaryTree.EmptyNode(),
                    1,
                    IntBinaryTree.EmptyNode()),
            10,
            IntBinaryTree.EmptyNode())

    print(toCollection(tree))
}