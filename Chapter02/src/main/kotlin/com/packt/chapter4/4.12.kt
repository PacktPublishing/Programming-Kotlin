fun main(args: Array<String>) {

  val printHello = { println("hello") }
  printHello()

  val printMessage = { message: String -> println(message) }

  printMessage("hello")


}