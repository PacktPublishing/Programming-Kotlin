import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext

fun main() {
  suspend fun child1() {
    println("Starting child 1")
    delay(100)
    throw RuntimeException("Boom")
  }
  suspend fun child2() {
    println("Starting child 2")
    delay(100)
    println("Completing child 2")
  }
  runBlocking {
    supervisorScope {
      launch {
        child1()
      }
      launch {
        child2()
      }
    }
  }
}
