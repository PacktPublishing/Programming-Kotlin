import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
  runBlocking {
    println("Parent starting")
    launch {
      println("Child a starting")
      delay(100)
      println("Child a complete")
    }
    launch {
      println("Child b starting")
      delay(100)
      println("Child b complete")
    }
    println("Parent complete")
  }
  println("Parent returned")
}