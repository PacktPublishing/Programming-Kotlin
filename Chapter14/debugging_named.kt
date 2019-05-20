import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
  fun logger(message: String) = println("${Thread.currentThread().name} $message")
  val jobs = listOf("parser", "crawler", "lexer").map {
    GlobalScope.launch(CoroutineName(it)) {
      repeat(3) {
        delay(300)
        logger("I'm working hard")
      }
    }
  }
  runBlocking {
    logger("Starting calculation")
    jobs.forEach { it.join() }
  }
}