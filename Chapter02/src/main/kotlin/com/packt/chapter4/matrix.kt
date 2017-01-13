class TwoByTwoMatrix(val a: Int, val b: Int, val c: Int, val d: Int) {
  operator fun plus(matrix: TwoByTwoMatrix): TwoByTwoMatrix =
      TwoByTwoMatrix(a + matrix.a, b + matrix.b, c + matrix.c, d + matrix.d)
}

fun test() {
  val m1 = TwoByTwoMatrix(1, 2, 3, 4)
  val m2 = TwoByTwoMatrix(5, 6, 7, 8)
  val m3 = m1 + m2
}
