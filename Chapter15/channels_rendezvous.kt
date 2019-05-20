import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
  runBlocking {
    val channel = Channel<String>()
    launch {
      println("About to produce an element")
      channel.send("foo")
      println("Produced element foo")
    }
    launch {
      println("About to receive an element")
      delay(100)
      println("Received element " + channel.receive())
    }
  }
}