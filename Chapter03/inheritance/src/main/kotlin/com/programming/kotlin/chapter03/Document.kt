package com.programming.kotlin.chapter03

import java.io.InputStream

interface IPersistable {
    fun save(stream: InputStream)
}

interface IPrintable {
    fun print(){
        println("aaa")
    }
}

abstract class Document(val title: String) {

}

class TextDocument(title: String) : IPersistable, Document(title), IPrintable {
    override fun save(stream: InputStream) {
        println("Saving to input stream")
    }

    override fun print() {
        println("Document name:$title")
    }
}