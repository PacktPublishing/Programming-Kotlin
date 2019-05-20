import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select

suspend fun crawl(url: String): String = TODO()
fun parse(html: String): Unit = TODO()

fun main() {
  val urls = listOf("..", "..", "..")
  runBlocking {
    val deferreds = urls.map {
      async {
        crawl(it)
      }
    }
    select<Unit> {
      deferreds.forEach {
        it.onAwait { html ->
          parse(html)
        }
      }
    }
  }
}

interface Shape {
  val area: Double
}

class Rectangle(val width: Double, val height: Double) : Shape {
  override val area: Double
    get() = width * height

  val isSquare: Boolean = width == height
}