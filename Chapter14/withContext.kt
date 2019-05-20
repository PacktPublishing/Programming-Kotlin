import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


fun main() {
  fun logger(message: String) = println("${Thread.currentThread().name} $message")
  runBlocking {
    logger("Starting")
    withContext(newSingleThreadContext("A")) {
      logger("Running in new context")
      withContext(newSingleThreadContext("B")) {
        logger("Running in new context")
      }
    }
    logger("Completing")
  }
}
