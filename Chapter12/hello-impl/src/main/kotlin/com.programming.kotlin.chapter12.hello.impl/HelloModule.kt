package com.programming.kotlin.chapter12.hello.impl

import com.google.inject.AbstractModule
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport
import com.programming.kotlin.chapter12.hello.api.HelloService

class HelloModule : AbstractModule(), ServiceGuiceSupport {
  override fun configure() {
    bindServices(serviceBinding(HelloService::class.java, HelloServiceImpl::class.java))
  }
}