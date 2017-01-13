import com.packt.chapter4.Named
import java.util.concurrent.Executors
import kotlin.concurrent.thread

fun getters() {
  val named = Named()
  println("My name is " + named.name)
  named.name = "new name"
}

fun sams() {
  val threadPool = Executors.newFixedThreadPool(4)
  threadPool.submit {
    println("I don't have a lot of work to do")
  }

  threadPool.submit(object : Runnable {
    override fun run() {
      println("I don't have a lot of work to do")
    }
  })
}