import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
  val handler = CoroutineExceptionHandler { context, throwable ->
    println("Intercepted exception of type ${throwable.javaClass.simpleName}")
  }
  runBlocking {
    val job = GlobalScope.launch(handler) {
      launch {
        println("Starting first child")
        delay(1000)
        println("First child completed")
      }
      launch {
        println("Second child throwing exception")
        delay(100)
        throw IndexOutOfBoundsException()
      }
    }
    job.join()
  }
}