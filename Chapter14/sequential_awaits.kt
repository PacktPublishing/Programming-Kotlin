import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
  suspend fun echo(msg: String): String {
    println("Suspending echo")
    delay(100)
    println("Resumed echo")
    return msg
  }
  runBlocking {
    val foo = async {
      echo("foo")
    }
    println("Calling await")
    println(foo.await())
    val bar = async {
      echo("bar")
    }
    println("Calling await")
    println(bar.await())
  }
}