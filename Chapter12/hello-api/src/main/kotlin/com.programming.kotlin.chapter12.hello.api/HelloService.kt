package com.programming.kotlin.chapter12.hello.api

import akka.Done
import akka.NotUsed
import com.lightbend.lagom.javadsl.api.Descriptor
import com.lightbend.lagom.javadsl.api.Service
import com.lightbend.lagom.javadsl.api.Service.named
import com.lightbend.lagom.javadsl.api.Service.pathCall
import com.lightbend.lagom.javadsl.api.ServiceCall

/**
 * The Hello service interface.
 *
 *
 * This describes everything that Lagom needs to know about how to serve and
 * consume the Hello.
 */
/*
interface HelloService : Service {

    */
/**
     * Example: curl http://localhost:9000/api/hello/Alice
     *//*

    fun hello(id: String): ServiceCall<NotUsed, String>


    */
/**
     * Example: curl -H "Content-Type: application/json" -X POST -d '{"message":
     * "Hi"}' http://localhost:9000/api/hello/Alice
     *//*

    fun useGreeting(id: String): ServiceCall<GreetingMessage, Done>

    override fun descriptor(): Descriptor {

        val helloCall: (String) -> ServiceCall<NotUsed, String> = { this.hello(it) }
        val helloGreetings: (String) -> ServiceCall<GreetingMessage, Done> = { this.useGreeting(it) }


        return named("hello")
                .withCalls(
                        pathCall("/api/hello/:id", helloCall),
                        pathCall("/api/hello/:id", helloGreetings))
                .withAutoAcl(true)
    }
}
*/
