import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
  suspend fun a(): Int = Random.nextInt()
  suspend fun b(a: Int) {
    println("Using $a")
  }
  runBlocking {
    val a = a()
    b(a)
  }
}