import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
  val job = GlobalScope.launch {
    delay(1000L)
    println("Hello")
  }
  runBlocking {
    job.join()
    println("World")
  }
}
