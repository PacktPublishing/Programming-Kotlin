fun hello(): String = "hello world"

fun hello(name: String): String = "hello to you $name"

fun invocation() {
  val string = "hello"
  val length = string.take(5)
}

object Square {

  fun printArea(width: Int, height: Int): Unit {
    val area = calculateArea(width, height)
    println("The area is $area")
  }

  fun calculateArea(width: Int, height: Int): Int {
    return width * height
  }
}