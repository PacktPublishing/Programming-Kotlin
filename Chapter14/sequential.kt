import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
  suspend fun a() {
    delay(100)
    println("a")
  }
  suspend fun b() {
    delay(100)
    println("b")
  }
  runBlocking {
    a()
    b()
    println("Done")
  }
}