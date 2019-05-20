import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
  runBlocking {
    val channel = Channel<Int>(3)
    launch {
      for (k in 1..5) {
        channel.send(k)
        println("Sent element $k")
      }
    }
    launch {
      repeat(5) {
        delay(10)
        println("Received element " + channel.receive())
      }
    }
  }
}