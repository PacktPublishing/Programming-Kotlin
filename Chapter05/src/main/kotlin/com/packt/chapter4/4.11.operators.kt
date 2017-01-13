import com.packt.chapter4.Matrix
import java.util.*

operator fun Thread.plus(a: Int): Int = a

fun overloading() {
  val thread = Thread(Runnable {})
  thread.plus(1)
}

fun javainterop() {
  val matrix1 = Matrix()
  val matrix2 = Matrix()
  val matrix3 = matrix1 + matrix2
}


enum class Piece {
  Empty, Pawn, Bishop, Knight, Rook, Queen, King
}

class ChessBoard() {


  private val board = Array<Piece>(64, { Piece.Empty })

  operator fun get(x: Int, y: Int): Piece = board[y * 8 + x]

  operator fun set(x: Int, y: Int, value: Piece): Unit {
    board[y * 8 + x] = value
  }
}

fun getset() {
  val board = ChessBoard()
  board[0, 4] = Piece.Queen
  println(board[0, 4])
}

class RandomLongs(seed: Long) {
  val random = Random(seed)
  operator fun invoke(): Long = random.nextLong()
}

fun invokeExample() {
  val random = RandomLongs(123456789)
  val randoms = listOf(random(), random(), random())
}

object Min {
  operator fun invoke(a: Int, b: Int): Int = if (a <= b) a else b
  operator fun invoke(a: Int, b: Int, c: Int): Int = invoke(invoke(a, b), c)
  operator fun invoke(a: Int, b: Int, c: Int, d: Int): Int = invoke(invoke(a, b), invoke(c, d))
  operator fun invoke(a: Long, b: Long): Long = if (a <= b) a else b
  operator fun invoke(a: Long, b: Long, c: Long): Long = invoke(invoke(a, b), c)
  operator fun invoke(a: Long, b: Long, c: Long, d: Long): Long = invoke(invoke(a, b), invoke(c, d))
}

class BingoNumber(val name: String, val age: Int) {

  operator fun compareTo(other: BingoNumber): Int {
    return when {
      age < other.age -> -1
      age > other.age -> 1
      else -> 0
    }
  }
}

fun comparisonExample() {
  val a = BingoNumber("Key to the Door", 21)
  val b = BingoNumber("Jump and Jive", 35)
  println(a < b) // true
  println(b > a) // false
}

class Counter(var k: Int) {
  operator fun plus(j: Int): Counter {
    return Counter(k + j)
  }
}

fun counterExample() {
  var counter = Counter(1)
  counter = counter + 3
  counter += 2
}