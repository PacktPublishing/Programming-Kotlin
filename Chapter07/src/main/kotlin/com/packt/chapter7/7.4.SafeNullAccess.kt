package com.packt.chapter7

class Person(name: String, val address: Address?)
class Address(name: String, val postcode: String, val city: City?)
class City(name: String, val country: Country?)
class Country(val name: String)

fun getCountryName(person: Person?): String? {
  var countryName: String? = null
  if (person != null) {
    val address = person.address
    if (address != null) {
      val city = address.city
      if (city != null) {
        val country = city.country
        if (country != null) {
          countryName = country.name
        }
      }
    }
  }
  return countryName
}

fun getCountryNameSafe(person: Person?): String? {
  return person?.address?.city?.country?.name
}

fun nullableAddress(): Address? = TODO()

fun forceVariable() {
  val nullableName: String? = "george"
  val name: String = nullableName!!
}

fun forceFunction() {
  val postcode: String = nullableAddress()!!.postcode
}

