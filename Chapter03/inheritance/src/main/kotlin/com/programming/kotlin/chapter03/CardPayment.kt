package com.programming.kotlin.chapter03

import org.joda.time.DateTime
import java.math.BigDecimal

class CardPayment(amount: BigDecimal, val number: String, val expiryDate: DateTime, val type: CardType) : Payment(amount)