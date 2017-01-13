package com.packt.chapter11

import io.kotlintest.Eventually
import io.kotlintest.Tag
import io.kotlintest.specs.ShouldSpec

object ElasticSearch : Tag()
object Windows : Tag()

class ConfigExample : ShouldSpec(), Eventually {
  init {
    should("run multiple times") {
      // test logic
    }.config(invocations = 5, threads = 4)

    should("run multiple times in multiple threads") {
      // test logic
    }.config(invocations = 20, threads = 4)

    should("be disabled") {
      // test logic
    }.config(enabled = false)

    fun isMultiCore(): Boolean = Runtime.getRuntime().availableProcessors() > 1

    should("only run on multicore machines") {
      // test logic
    }.config(enabled = isMultiCore())

    should("this test is tagged") {
      // test logic
    }.config(tags = setOf(ElasticSearch, Windows))
  }
}

class OneInstanceOfTheseTests : ShouldSpec() {
  override val oneInstancePerTest = true

  init {
    // tests here
  }
}