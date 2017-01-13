package com.packt.chapter7

fun javaStyle(address: Address) {
  var postcode: String? = null
  if (address == null) {
    postcode = "No Postcode"
  } else {
    if (address.postcode == null) {
      postcode = "No Postcode"
    } else {
      postcode = address.postcode
    }
  }
}

fun exampleElvis() {
  val nullableName: String? = "william"
  val name: String = nullableName ?: "default_name"

  val nullableAddress: Address? = null
  val postcode: String = nullableAddress?.postcode ?: "default_postcode"
}