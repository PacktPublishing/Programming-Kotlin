import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
  suspend fun child1() {
    println("Starting child 1")
    delay(2000)
    println("Completing child 1")
  }
  suspend fun child2() {
    println("Starting child 2")
    delay(1000)
    throw RuntimeException("Boom")
  }
  try {
    runBlocking {
      launch {
        child1()
      }
      launch {
        child2()
      }
    }
  } catch (e: Exception) {
    println("Failed with ${e.message}")
  }
}