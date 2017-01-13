import com.sun.org.apache.xpath.internal.compiler.Keywords

fun equals(first: Any, second: Any): Unit {
  if (first != second)
    throw RuntimeException("$first was not equal to $second")
}

fun Any.shouldEqual(other: Any): Unit {
  if (this != other)
    throw RuntimeException("$this was not equal to $other")
}

infix fun <E> Collection<E>.shouldContain(element: E): Unit {
  if (!this.contains(element))
    throw RuntimeException("Collection did not contain $element")
}

interface Matcher<T> {

  fun test(lhs: T): Unit

  infix fun or(other: Matcher<T>): Matcher<T> = object : Matcher<T> {
    override fun test(lhs: T) {
      try {
        this@Matcher.test(lhs)
      } catch (e: RuntimeException) {
        other.test(lhs)
      }
    }
  }
}

fun <T> contain(rhs: T) = object : Matcher<Collection<T>> {
  override fun test(lhs: Collection<T>): Unit {
    if (!lhs.contains(rhs))
      throw RuntimeException("Collection did not contain $rhs")
  }
}

fun <T> beEmpty() = object : Matcher<Collection<T>> {
  override fun test(lhs: Collection<T>) {
    if (lhs.isNotEmpty())
      throw RuntimeException("Collection should be empty")
  }
}


infix fun <T> T.should(matcher: Matcher<T>) {
  matcher.test(this)
}

class CollectionMatchers<T>(val collection: Collection<T>) {

  fun contain(rhs: T): Unit {
    if (!collection.contains(rhs))
      throw RuntimeException("Collection did not contain $rhs")
  }

  fun notContain(rhs: T): Unit {
    if (collection.contains(rhs))
      throw RuntimeException("Collection should not contain $rhs")
  }

  fun haveSizeLessThan(size: Int): Unit {
    if (collection.size >= size)
      throw RuntimeException("Collection should have size less than $size")
  }
}


infix fun <T> Collection<T>.should(fn: CollectionMatchers<T>.() -> Unit) {
  val matchers = CollectionMatchers(this)
  matchers.fn()
}

fun dsltest() {
  val listOfNames = listOf("george", "harry", "william")
  listOfNames should (contain("george") or beEmpty())

  listOfNames should {
    contain("george")
    contain("harry")
    notContain("francois")
    haveSizeLessThan(4)
  }
}