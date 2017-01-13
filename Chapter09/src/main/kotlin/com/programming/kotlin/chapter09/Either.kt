package com.programming.kotlin.chapter09

sealed abstract class Either<out L, out R> {
    //data class Left<out L, out R>(val value: L) : Either<L, R>()
    //data class Right<out L, out R>(val value: R) : Either<L, R>()
}