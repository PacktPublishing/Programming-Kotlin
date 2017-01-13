package com.programming.kotlin.chapter12.hello.api

import com.fasterxml.jackson.module.kotlin.*
import com.fasterxml.jackson.databind.ObjectMapper

object Jackson{
  val mapper: ObjectMapper = {
    ObjectMapper().registerKotlinModule()
  }()
}