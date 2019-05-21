import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
  GlobalScope.launch {
    delay(1000)
    println("I am a coroutine")
  }
  println("I am the main thread")
  Thread.sleep(2000)
}
