import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
  GlobalScope.launch {
    // create a new global level coroutine
    delay(1000L) // wait for 1 second
    println("World!")
  }
  println("Hello,") // main thread continues while coroutine is delayed
  Thread.sleep(2000L) // block main thread to keep JVM alive
  GlobalScope.launch(context = Dispatchers.IO) {
    // will get dispatched to DefaultDispatcher
    println("Default               : I'm working in thread ${Thread.currentThread().name}")
  }


}