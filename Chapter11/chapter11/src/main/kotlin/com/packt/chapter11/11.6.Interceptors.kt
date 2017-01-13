package com.packt.chapter11

import io.kotlintest.Spec
import io.kotlintest.TestCaseContext
import io.kotlintest.specs.StringSpec

class SpecInterceptorTest : StringSpec() {

  val mySpecInterceptor: (Spec, () -> Unit) -> Unit = { spec, tests ->
    val start = System.currentTimeMillis()
    val end = System.currentTimeMillis()
    tests()
    val duration = end - start
    println("The spec took $duration millis")
  }

  override val specInterceptors: List<(Spec, () -> Unit) -> Unit> = listOf(mySpecInterceptor)

  init {

    val myinterceptor: (TestCaseContext, () -> Unit) -> Unit = { context, test ->
      val start = System.currentTimeMillis()
      test()
      val end = System.currentTimeMillis()
      val duration = end - start
      println("This test took $duration millis")
    }

    "this test has an interceptor" {
      // test logic here
    }.config(interceptors = listOf(myinterceptor))

    "so does this test" {
      // test logic here
    }.config(interceptors = listOf(myinterceptor))
  }
}