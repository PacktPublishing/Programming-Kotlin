import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {

  suspend fun printShippingLabels() {
    delay(3000)
    println("After three seconds")
  }

  suspend fun processPayment() {
    delay(2000)
    println("Order after two seconds")
  }

  suspend fun sendEmails() {
    delay(1000)
    println("Payment after one second")
  }

  println("Starting")
  val time = measureTimeMillis {
    runBlocking {
      printShippingLabels()
      processPayment()
      sendEmails()
    }
    println("runBlocking done")
  }
  println("Completed in $time ms")
}