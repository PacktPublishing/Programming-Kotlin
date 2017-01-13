/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 *//*

package com.programming.kotlin.chapter12.hello.impl;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;
import com.programming.kotlin.chapter12.hello.api.HelloService;

*/
/**
 * The module that binds the HelloService so that it can be served.
 *//*

public class HelloModule extends AbstractModule implements ServiceGuiceSupport {
  @Override
  protected void configure() {
    bindServices(serviceBinding(HelloService.class, HelloServiceImpl.class));
  }
}
*/
