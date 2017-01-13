import java.util.concurrent.ConcurrentHashMap

fun main(args: Array<String>) {
  val memfib = memoize(::fib)
  val qqq = ::fib.memoized()
  for (k in 1..1000) {
    val start = System.currentTimeMillis()
    val result = memfib(k)
    val end = System.currentTimeMillis()
    val duration = end - start
    println("fib($k)=$result took $duration ms")
  }
}

val map = mutableMapOf<Int, Long>()

fun memfib(k: Int): Long {
  return map.getOrPut(k) {
    when (k) {
      0 -> 1
      1 -> 1
      else -> memfib(k - 1) + memfib(k - 2)
    }
  }
}

fun <A, R> memoize(fn: (A) -> R): (A) -> R {
  val map = ConcurrentHashMap<A, R>()
  return { a ->
    map.getOrPut(a) {
      fn(a)
    }
  }
}

fun <A, R> Function1<A, R>.memoized(): (A) -> R {
  val map = ConcurrentHashMap<A, R>()
  return { a ->
    map.getOrPut(a) {
      this.invoke(a)
    }
  }
}