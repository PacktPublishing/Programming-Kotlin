import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
  runBlocking {
    val deferred = async {
      println("Computing value")
      delay(1000)
      "result"
    }
    val result = deferred.await()
    println("The result is $result")
  }
}