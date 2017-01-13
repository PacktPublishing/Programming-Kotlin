package com.programming.kotlin.chapter06

fun main(args: Array<String>) {
    val student = Student("Jamie Fox", 20)
    println("${student.name} is ${student.age} years old")
    student.age += 1
    println("${student.name} is ${student.age} years old")

    val withPrivateSetter = WithPrivateSetter(10)
    println("withPrivateSetter:${withPrivateSetter.SomeProperty}")


    val withInheritance = WithInheritanceDerived(true)
    withInheritance.doSomething()
    println("withInheritance:${withInheritance.isAvailable}")

    val container = Container()
    container.initProperty(DelayedInstance(10))
    println("with delayed initialization:Number=${container.delayedInitProperty.number}")

    val record = Record("111")
    println(record.id)


    val measure = Measure()
    measure.writeTimestamp = System.currentTimeMillis()
    println("Current measure taken at:${measure.writeTimestamp}")
    Thread.sleep(100)
    measure.writeTimestamp = System.currentTimeMillis()
    println("Current measure taken at:${measure.writeTimestamp}")

    val propsByMap = PropsByMap()
    println("Props with map: p1=${propsByMap.p1}")
    println("Props with map: p2=${propsByMap.p2}")
    propsByMap.p1 = 100
    println("Props with map: p1=${propsByMap.p1}")


    val player = Player(mapOf("name" to "Alex Jones", "age" to 28, "height" to 1.82))
    println("Player ${player.name} is ${player.age} ages old and is ${player.height} cm tall")

    val trivial = Trivial()
    println("Trivial flag is :${trivial.flag}")

    val withLazyProperty = WithLazyProperty()
    val total = withLazyProperty.foo + withLazyProperty.foo
    println("Lazy property total:$total")

    val x = WithLazyPropertyWithLocking()
    val totalx = withLazyProperty.foo + withLazyProperty.foo
    println("Lazy property total:$totalx")


    val onChange = WithObservableProp()
    onChange.value = 10
    onChange.value = -20

    val positiveVal = OnlyPositiveValues()
    positiveVal.value = 100
    println("positiveVal value is ${positiveVal.value}")

    positiveVal.value = -100
    println("positiveVal value is ${positiveVal.value}")

    positiveVal.value = 111
    println("positiveVal value is ${positiveVal.value}")

    val nonNull = NonNullProp()
    nonNull.value = "Kotlin rocks"
    println("Non null value is: ${nonNull.value}")


}

