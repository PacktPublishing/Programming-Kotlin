import com.sksamuel.book.new
import java.util.*

fun <T> printRepeated(t: T, k: Int): Unit {
  for (x in 0..k) {
    println(t)
  }
}

fun <T> choose(t1: T, t2: T, t3: T): T {
  return when (Random().nextInt(3)) {
    0 -> t1
    1 -> t2
    else -> t3
  }
}

fun generics() {
  val random = choose(5, 7, 9)
}