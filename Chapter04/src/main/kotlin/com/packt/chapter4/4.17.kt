import java.util.concurrent.atomic.AtomicInteger

val counter = AtomicInteger(1)

fun unpure(k: Int): Int {
  return counter.incrementAndGet() + k
}