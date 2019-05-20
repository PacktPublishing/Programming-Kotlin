import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

fun main() {
  runBlocking(Dispatchers.IO) {
    println(Thread.currentThread().name)
  }
}