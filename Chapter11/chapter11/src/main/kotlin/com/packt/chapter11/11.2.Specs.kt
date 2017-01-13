package com.packt.chapter11

import io.kotlintest.specs.BehaviorSpec
import io.kotlintest.specs.FeatureSpec
import io.kotlintest.specs.FlatSpec
import io.kotlintest.specs.ShouldSpec
import io.kotlintest.specs.StringSpec
import io.kotlintest.specs.WordSpec
import java.util.*

class MyFlatSpec : FlatSpec() {
  init {
    "String.length" should "return the length of the string" {
      "sammy".length shouldBe 5
      "".length shouldBe 0
    }
  }
}

class MyWordSpec : WordSpec() {
  init {
    "String.length" should {
      "return the length of the string" {
        "sammy".length shouldBe 5
        "".length shouldBe 0
      }
    }
  }
}

class MyShouldSpec : ShouldSpec() {
  init {
    "String.length" {
      should("return the length of the string") {
        "sammy".length shouldBe 5
      }
      should("support empty strings") {
        "".length shouldBe 0
      }
    }
  }
}

class MyBehaviorSpec : BehaviorSpec() {
  init {
    given("a stack") {
      val stack = Stack<String>()

      `when`("an item is pushed") {
        stack.push("kotlin")

        then("the stack should not be empty") {
          stack.isEmpty() shouldBe true
        }
      }
      `when`("the stack is popped") {
        stack.pop()
        then("it should be empty") {
          stack.isEmpty() shouldBe false
        }
      }
    }
  }
}

class MyFeatureSpec : FeatureSpec() {
  init {
    feature("a stack") {
      val stack = Stack<String>()
      scenario("should be non-empty when an item is pushed") {
        stack.push("kotlin")
        stack.isEmpty() shouldBe true
      }
      scenario("should be empty when the item is popped") {
        stack.pop()
        stack.isEmpty() shouldBe false
      }
    }
  }
}

class MyStringSpec : StringSpec() {
  init {
    "strings.length should return size of string" {
      "hello".length shouldBe 5
    }
  }
}