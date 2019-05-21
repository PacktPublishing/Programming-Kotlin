import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

interface Callback<T> {
  fun onSuccess(result: T)
  fun onFailure(e: Throwable)
}

suspend fun <T> awaitCallback(thunk: (Callback<T>) -> Unit): T {
  return suspendCancellableCoroutine { cont ->
    thunk(object : Callback<T> {
      override fun onSuccess(result: T) = cont.resume(result)
      override fun onFailure(e: Throwable) {
        cont.resumeWithException(e)
      }
    })
  }
}

fun fetchUsername(id: Int, callback: Callback<String>) {
  Thread.sleep(100)
  if (id == 1)
    callback.onSuccess("sam")
  else
    callback.onFailure(IllegalArgumentException())
}

fun main() = runBlocking {
  try {
    val username = awaitCallback<String> { fetchUsername(1, it) }
    println("User 1 has username $username")
  } catch (e: Exception) {
    println("Unknown user 1")
  }
  try {
    val username = awaitCallback<String> { fetchUsername(2, it) }
    println("User 2 has username $username")
  } catch (e: Exception) {
    println("Unknown user 2")
  }
}