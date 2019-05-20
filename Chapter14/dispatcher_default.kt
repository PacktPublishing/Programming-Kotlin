import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
  runBlocking {
    println("A: " + Thread.currentThread().name)
    launch(Dispatchers.Default) {
      println("B: " + Thread.currentThread().name)
    }
    launch {
      println("C: " + Thread.currentThread().name)
    }
  }
}