import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
  runBlocking {
    val channel = Channel<Int>()
    launch {
      for (k in 1..5) {
        channel.send(k)
        println("Sent element $k")
      }
      println("Closing channel")
      channel.close()
    }
    launch {
      for (k in channel) {
        println("Received element $k")
      }
      println("Channel has closed")
    }
  }
}