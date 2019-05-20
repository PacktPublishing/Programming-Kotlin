import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun main() {
  val handler = CoroutineExceptionHandler { context, throwable ->
    println("Intercepted exception of type ${throwable.javaClass.simpleName}")
  }
  runBlocking {
    val deferred = GlobalScope.async(handler) {
      throw IndexOutOfBoundsException()
    }
    deferred.await()
  }
}