import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
  runBlocking {
    var child: Job? = null
    val job = launch {
      child = launch {
        delay(1000)
        println("I am a child")
      }
    }
    delay(100)
    job.cancel()
    println("Cancelled=" + child!!.isCancelled)
  }
}