import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors.newSingleThreadExecutor

fun main() {
  runBlocking {
    val executor = newSingleThreadExecutor { r -> Thread(r, "my-executor-dispatcher") }
    val dispatcher = executor.asCoroutineDispatcher()
    launch(dispatcher) {
      println(Thread.currentThread().name)
    }
    launch {
      println(Thread.currentThread().name)
    }
  }
}