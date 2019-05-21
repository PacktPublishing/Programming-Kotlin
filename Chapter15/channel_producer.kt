import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main() {
  runBlocking {
    val channel = produce {
      for (k in 1..5) {
        send(k)
      }
    }
    channel.consumeEach { println(it) }
    println("Done!")
  }
}