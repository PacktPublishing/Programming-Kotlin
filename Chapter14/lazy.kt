import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
  val job = GlobalScope.launch(start = CoroutineStart.LAZY) {
    delay(100)
    println("World")
  }
  runBlocking {
    delay(1000)
    println("Hello")
    job.join()
  }
}