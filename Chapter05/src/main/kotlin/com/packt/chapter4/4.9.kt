fun positiveRoot(k: Int): Double {
  require(k >= 0)
  return Math.sqrt(k.toDouble())
}

fun negativeRoot(k: Int): Double {
  require(k >= 0)
  return -Math.sqrt(k.toDouble())
}

fun roots(k: Int): Array<Double> {
  require(k >= 0)
  val root = Math.sqrt(k.toDouble())
  return arrayOf(root, -root)
}

class Roots(pos: Double, neg: Double)

fun roots2(k: Int): Roots {
  require(k >= 0)
  val root = Math.sqrt(k.toDouble())
  return Roots(root, -root)
}

fun roots3(k: Int): Pair<Double, Double> {
  require(k >= 0)
  val root = Math.sqrt(k.toDouble())
  return Pair(root, -root)
}

fun main() {
  val (pos, neg) = roots3(16)
}