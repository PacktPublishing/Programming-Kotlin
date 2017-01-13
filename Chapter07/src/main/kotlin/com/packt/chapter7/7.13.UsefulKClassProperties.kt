import java.io.Closeable
import java.io.Serializable
import kotlin.reflect.allSuperclasses
import kotlin.reflect.superclasses

class Sandwich<F1, F2>()

class ManyParents : Serializable, Closeable, java.lang.AutoCloseable {
  override fun close() {
  }
}

fun main(args: Array<String>) {

  val types = Sandwich::class.typeParameters
  types.forEach {
    println("Type ${it.name} has upper bound ${it.upperBounds}")
  }

  val superclasses = ManyParents::class.superclasses
  superclasses.forEach {
    println(it)
  }

  val allSuperclasses = ManyParents::class.allSuperclasses
  allSuperclasses.forEach {
    println(it)
  }
}