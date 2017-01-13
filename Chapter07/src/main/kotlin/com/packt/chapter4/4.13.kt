fun fib(k: Int): Int = when (k) {
  0 -> 1
  1 -> 1
  else -> fib(k - 1) + fib(k - 2)
}

fun fact(k: Int): Int {
  if (k == 0) return 1
  else return k * fact(k - 1)
}

fun fact2(k: Int): Int {
  tailrec fun factTail(m: Int, n: Int): Int {
    if (m == 0) return n
    else return factTail(m - 1, m * n)
  }
  return factTail(k, 1)
}

fun main(args: Array<String>) {
  for (k in 1..10) {
    println(fact(k))
    println(fact2(k))
  }
}