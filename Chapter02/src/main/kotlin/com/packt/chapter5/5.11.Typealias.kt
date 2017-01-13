typealias Result = Map<String, Long>

interface Exchange<I, O>
interface HttpRequest
interface HttpResponse

typealias HttpExchange = Exchange<HttpRequest, HttpResponse>

fun process1(exchange: Exchange<HttpRequest, HttpResponse>): Exchange<HttpRequest, HttpResponse> = TODO()
fun process2(exchange: HttpExchange): HttpExchange = TODO()

typealias String1 = String
typealias String2 = String

fun printString(str: String1): Unit = println(str)

fun aliases() {
  val a: String2 = "I am a String"
  printString(a)
}

fun volume(width: Int, length: Int, height: Int): Int = width * length * height

typealias Width = Int
typealias Length = Int
typealias Height = Int

fun volume2(width: Width, length: Length, height: Height): Int = width * length * height

fun volume2test() {
  val width: Width = 2
  val length: Length = 3
  val height: Height = 4
  volume2(width, length, height)
  volume2(height, width, length)
  volume2(width, width, width)
}