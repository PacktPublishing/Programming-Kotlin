package com.packt.chapter11

import com.sun.net.httpserver.HttpServer
import io.kotlintest.ProjectConfig
import java.net.InetSocketAddress
import java.util.concurrent.Executors

object MyProjectConfig : ProjectConfig() {

  var server: HttpServer? = null

  override fun beforeAll() {
    val addr = InetSocketAddress(8080)
    val server = HttpServer.create(addr, 0)
    server.executor = Executors.newCachedThreadPool()
    server.start()
    println("Server is listening on port 8080")
  }

  override fun afterAll() {
    server!!.stop(0)
  }
}