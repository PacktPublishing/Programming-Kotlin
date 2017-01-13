package com.packt.chapter7

import java.io.FileNotFoundException
import java.nio.file.Paths
import kotlin.jvm.Throws

class File(val path: String) {
  @Throws(FileNotFoundException::class)
  fun exists(): Boolean {
    if (!Paths.get(path).toFile().exists())
      throw FileNotFoundException("$path does not exist")
    return true
  }
}