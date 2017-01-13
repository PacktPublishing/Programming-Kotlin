package com.packt.chapter7

@Target(AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.TYPE_PARAMETER,
    AnnotationTarget.FIELD,
    AnnotationTarget.CONSTRUCTOR,
    AnnotationTarget.TYPE,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.EXPRESSION,
    AnnotationTarget.TYPEALIAS)
annotation class Foo

@Target(AnnotationTarget.CONSTRUCTOR)
@Retention(AnnotationRetention.SOURCE)
annotation class Woo

annotation class Ipsum(val text: String)

@Foo class MyClass

@Foo class MyInterface

@Foo object MyObject

fun bar(@Foo param: Int): Int = param

@Foo fun foo(): Int = 0

@Foo typealias MYC = MyClass

class PropertyClass {
  @Foo var name: String? = null
}

class Bar @Foo constructor(name: String)

fun expressionAnnotation(): Int {
  val str = @Foo "hello foo"
  return (@Foo 123)
}

annotation class Description(val summary: String)

@Description("This class creates Executor instances") class Executors

fun main(args: Array<String>) {
  val desc = Executors::class.annotations.first() as Description
  println(desc.summary)
}