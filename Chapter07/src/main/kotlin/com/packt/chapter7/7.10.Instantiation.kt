package com.packt.chapter7

import java.nio.file.Files
import java.nio.file.Paths
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.createInstance

class PositiveInteger(value: Int = 0)

fun createInteger(kclass: KClass<PositiveInteger>): PositiveInteger {
  return kclass.createInstance()
}

interface Ingester {
  fun ingest(): Unit
}

fun ingesters() {

  val props = Properties()
  props.load(Files.newInputStream(Paths.get("/some/path/to/config")))

  val classNames = (props.getProperty("ingesters") ?: "").split(',')

  val ingesters = classNames.map {
    Class.forName(it).kotlin.createInstance() as Ingester
  }

  ingesters.forEach { it.ingest() }
}