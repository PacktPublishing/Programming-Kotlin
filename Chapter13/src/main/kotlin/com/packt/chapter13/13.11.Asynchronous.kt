package com.packt.chapter13

data class Card(val number: String)

data class Order(val id: String, val card: Card)

fun persistOrder(order: Order, callback: (String) -> Unit): Unit = TODO()
fun chargeCard(card: Card, callback: (Boolean) -> Unit): Unit = TODO()
fun printInvoice(order: Order, callback: (Unit) -> Unit): Unit = TODO()

fun processOrder(order: Order) {
  persistOrder(order, {
    println("Order has been saved; charging card")
    chargeCard(order.card, { result ->
      if (result) {
        println("Order has been charged; printing invoice")
        printInvoice(order, {
          println("Invoice has been printed")
        })
      }
    })
  })
}