import java.math.BigDecimal
import java.math.RoundingMode
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

fun createThreadPool(): ExecutorService {
  val threadCount = Runtime.getRuntime().availableProcessors()
  return createThreadPool(threadCount)
}

fun createThreadPool(threadCount: Int): ExecutorService {
  return Executors.newFixedThreadPool(threadCount)
}

class Student(val name: String, val registered: Boolean, credits: Int) {
  constructor(name: String) : this(name, false, 0)
  constructor(name: String, registered: Boolean) : this(name, registered, 0)
}

class Student2(val name: String, val registered: Boolean = false, credits: Int = 0)

fun extension() {
  fun divide(divisor: BigDecimal, scale: Int = 0, roundingMode: RoundingMode = RoundingMode.UNNECESSARY): BigDecimal = BigDecimal(1)
  divide(BigDecimal(12.34))
  divide(BigDecimal(12.34), 8)
  divide(BigDecimal(12.34), roundingMode = RoundingMode.HALF_DOWN)
}

fun defaults47() {


}