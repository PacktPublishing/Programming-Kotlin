package com.programming.kotlin.chapter03

fun showFirstCharacter(input:String):Char{
    if(input.isEmpty()) throw IllegalArgumentException()
    return input.first()
}