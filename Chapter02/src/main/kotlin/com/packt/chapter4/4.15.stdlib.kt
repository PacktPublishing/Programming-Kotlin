import java.awt.BasicStroke
import java.awt.Color
import java.awt.Graphics2D
import java.awt.RenderingHints
import java.nio.file.Files
import java.nio.file.Paths

fun applyDemo() {

  val task = Runnable { println("Running") }

  Thread(task).apply {
    setDaemon(true)
  }.start()

  val thread = Thread(task)
  thread.setDaemon(true)
  thread.start()

}

fun letDemo() {

  val outputPath = Paths.get("/user/home").let {
    val path = it.resolve("output")
    path.toFile().createNewFile()
    path
  }
}

fun withExample() {

  val g2: Graphics2D = TODO()

  g2.stroke = BasicStroke(10F)
  g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
  g2.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE)
  g2.background = Color.BLACK

  with(g2) {
    stroke = BasicStroke(10F)
    setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
    setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE)
    background = Color.BLACK
  }
}

fun runExample() {
  val outputPath = Paths.get("/user/home").run {
    val path = resolve("output")
    path.toFile().createNewFile()
    path
  }
}

fun useExample() {
  val input = Files.newInputStream(Paths.get("input.txt"))
  val byte = input.use({ input.read() })
}

fun repeatExample() {
  repeat(10, { println("Hello") })
}

fun assertionsExample(str: String) {
  assert(str.length > 0, { "String should not be empty" })
  check(str.length > 0, { "String should not be empty" })
}

fun neverEmpty(str: String) {
  require(str.length > 0, { "String should not be empty" })
  println(str)
}

fun lazyExample() {
  fun readStringFromDatabase(): String = ""
  val lazyString = lazy { readStringFromDatabase() }
  lazyString.value
}