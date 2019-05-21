import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select

fun CoroutineScope.evens(): ReceiveChannel<Int> = produce {
  (2..100).step(2).map {
    delay(100)
    println("Producing $it")
    send(it)
  }
}

fun CoroutineScope.odds(): ReceiveChannel<Int> = produce {
  (1..999).step(2).map {
    delay(200)
    println("Producing $it")
    send(it)
  }
}

suspend fun selectNumbers(evens: ReceiveChannel<Int>, odds: ReceiveChannel<Int>) {
  select<Unit> {
    evens.onReceive {
      println("Received $it")
    }
    odds.onReceive {
      println("Received $it")
    }
  }
}

fun main() {
  runBlocking {
    val evens = evens()
    val odds = odds()
    repeat(6) {
      selectNumbers(evens, odds)
    }
  }
}