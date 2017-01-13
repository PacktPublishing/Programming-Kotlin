package com.programming.kotlin.chapter12.hello.api

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonDeserialize
data class GreetingMessage @JsonCreator constructor(val message: String)