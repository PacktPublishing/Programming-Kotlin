package com.packt.chapter11

import io.kotlintest.specs.StringSpec

val kings = listOf("Stephen I", "Henry I", "Henry II", "Henry III", "William I", "William II")

class InspectorTests : StringSpec() {
  init {

    "all kings should have a regal number" {
      forAll(kings) {
        it should endWith("I")
      }
    }

    "only one king has the name Stephen" {
      forOne(kings) {
        it should startWith("Stephen")
      }
    }

    "some kings have regal number II" {
      forSome(kings) {
        it should endWith("II")
      }
    }

    "at least one King has the name Henry" {
      forAtLeastOne(kings) {
        it should startWith("Henry")
      }
    }
  }
}