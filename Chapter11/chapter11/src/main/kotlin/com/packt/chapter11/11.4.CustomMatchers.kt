package com.packt.chapter11

import io.kotlintest.matchers.Matcher
import io.kotlintest.matchers.Result
import io.kotlintest.specs.FunSpec
import java.io.File

fun anImageFile() = object : Matcher<File> {

  private val suffixes = setOf("jpeg", "jpg", "png", "gif")

  override fun test(value: File): Result {

    val fileExists = value.exists()
    val hasImageSuffix = suffixes.any { value.name.toLowerCase().endsWith(it) }

    if (!fileExists) {
      return Result(false, "File $value should exist")
    }

    if (!hasImageSuffix) {
      return Result(false, "File $value does not have a well known image suffix")
    }

    return Result(true, "Test passed")
  }
}

fun exist2() = object : Matcher<File> {
  override fun test(value: File): Result {
    val fileExists = value.exists()
    return if (!fileExists) {
      return Result(false, "File $value should exist")
    } else {
      Result(true, "Test passed")
    }
  }
}

fun ofFileType(ext: String) = object : Matcher<File> {
  override fun test(value: File): Result {
    val isOfType = value.name.toLowerCase().endsWith(ext)
    return if (!isOfType) {
      Result(false, "File $value is not of type $ext")
    } else {
      Result(true, "Test passed")
    }
  }
}

class MatcherTest : FunSpec() {
  init {
    test("testing our file matcher") {
      val file = File("/home/packt/kotlin.jpg")
      file shouldBe anImageFile()
    }
  }
}

class MatcherTest2 : FunSpec() {
  init {
    test("testing our file matcher") {
      val dir = File("/home/packt/images")
      for (file in dir.listFiles()) {
        file should (exist2() and ofFileType("jpeg"))
      }
    }
  }
}