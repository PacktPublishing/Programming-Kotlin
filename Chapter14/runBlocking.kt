import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
  runBlocking {
    delay(1000)
    println("Hello World")
  }
  println("Done")
}