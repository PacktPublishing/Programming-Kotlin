package com.packt.chapter13

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption
import java.util.concurrent.CyclicBarrier
import java.util.concurrent.Executors

fun copyUsingBarrier(inputFiles: List<Path>, outputDirectories: List<Path>) {

  val executor = Executors.newFixedThreadPool(outputDirectories.size)
  val barrier = CyclicBarrier(outputDirectories.size)

  for (dir in outputDirectories) {
    executor.submit {
      CopyTask(dir, inputFiles, barrier)
    }
  }
}

class CopyTask(val dir: Path,
               val paths: List<Path>,
               val barrier: CyclicBarrier) : Runnable {

  override fun run() {
    for (path in paths) {
      val dest = dir.resolve(path)
      Files.copy(path, dest, StandardCopyOption.REPLACE_EXISTING)
      barrier.await()
    }
  }
}