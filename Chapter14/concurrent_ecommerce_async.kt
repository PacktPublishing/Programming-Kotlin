import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {

  suspend fun fetchOrder(): String {
    delay(3000)
    return "Order 123"
  }

  suspend fun fetchAddress(): String {
    delay(2000)
    return "10 Downing Street"
  }

  suspend fun fetchUsername(): String {
    delay(1000)
    return "Prime Minster"
  }

  println("Starting")
  val time = measureTimeMillis {
    runBlocking {
      val order = async {
        fetchOrder()
      }
      val address = async {
        fetchAddress()
      }
      val username = async {
        fetchUsername()
      }
      println("Shipping ${order.await()} to ${username.await()} at ${address.await()}")
    }
  }
  println("Completed in $time ms")
}