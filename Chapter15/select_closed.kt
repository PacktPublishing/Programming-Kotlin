import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select

fun main() {
  runBlocking {
    val producer = produce<Int> {
      var x = 1
      repeat(3) {
        send(x++)
      }
    }
    repeat(4) {
      select<Unit> {
        producer.onReceiveOrNull { value ->
          if (value == null)
            println("The channel has closed")
          else
            println("$value was produced")
        }
      }
    }
  }
}