import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Exception

fun main() {
  var job: Job? = null
  try {
    runBlocking {
      job = launch {
        delay(1000)
        println("I am a child")
      }
      delay(100)
      throw RuntimeException("boom")
    }
  } catch (e: Exception) {
    println("Catching exception")
  }
  println("Cancelled=" + job!!.isCancelled)
}