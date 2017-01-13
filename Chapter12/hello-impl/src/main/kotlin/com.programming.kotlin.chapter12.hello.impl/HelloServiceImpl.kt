package com.programming.kotlin.chapter12.hello.impl

import akka.Done
import akka.NotUsed
import com.lightbend.lagom.javadsl.api.ServiceCall
import com.lightbend.lagom.javadsl.persistence.PersistentEntityRegistry
import com.programming.kotlin.chapter12.hello.api.GreetingMessage
import com.programming.kotlin.chapter12.hello.api.HelloService
import java.util.*
import java.util.concurrent.CompletableFuture.completedFuture
import javax.inject.Inject

/**
 * Implementation of the HelloService.
 */
class HelloServiceImpl
@Inject
constructor(private val persistentEntityRegistry: PersistentEntityRegistry) : HelloService {
  init {
    persistentEntityRegistry.register(HelloEntity::class.java)
  }

  override fun sayHi(): ServiceCall<NotUsed, String> = ServiceCall<NotUsed, String> {
    completedFuture("Hi!")
  }

  override fun hello(id: String): ServiceCall<NotUsed, String> = ServiceCall<NotUsed, String> {
    // Look up the hello world entity for the given ID.
    val ref = persistentEntityRegistry.refFor(HelloEntity::class.java, id)
    // Ask the entity the Hello command.
    ref.ask<String, Hello>(Hello(id, Optional.empty<String>()))
  }


  override fun useGreeting(id: String): ServiceCall<GreetingMessage, Done> = ServiceCall<GreetingMessage, Done> {
    // Look up the hello world entity for the given ID.
    val ref = persistentEntityRegistry.refFor(HelloEntity::class.java, id)
    // Tell the entity to use the greeting message specified.
    ref.ask<Done, UseGreetingMessage>(UseGreetingMessage(it.message))
  }
}
