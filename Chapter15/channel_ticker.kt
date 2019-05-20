import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() = runBlocking {
  val ticker = ticker(delayMillis = 50, initialDelayMillis = 25)
  repeat(5) {
    val element = withTimeoutOrNull(15) { ticker.receive() }
    println("$it: $element")
  }
  ticker.cancel() // indicate that no more elements are needed
}