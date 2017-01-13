package com.packt.chapter8

import java.math.BigDecimal

interface Account {
  val balance: BigDecimal
}

data class SavingsAccount(override val balance: BigDecimal,
                          val interestRate: BigDecimal) : Account, Comparable<SavingsAccount> {
  override fun compareTo(other: SavingsAccount): Int = balance.compareTo(other.balance)
}

data class TradingAccount(override val balance: BigDecimal,
                          val margin: Boolean) : Account, Comparable<TradingAccount> {
  override fun compareTo(other: TradingAccount): Int = balance.compareTo(other.balance)
}

fun usingExample1() {
  val savings1 = SavingsAccount(BigDecimal(105), BigDecimal(0.04))
  val savings2 = SavingsAccount(BigDecimal(396), BigDecimal(0.05))
  savings1.compareTo(savings2)

  val trading1 = TradingAccount(BigDecimal(211), true)
  val trading2 = TradingAccount(BigDecimal(853), false)
  trading1.compareTo(trading2)
  // savings.compareTo(trading) compile error
}

interface Account2 : Comparable<Account2> {
  val balance: BigDecimal
  override fun compareTo(other: Account2): Int = balance.compareTo(other.balance)
}

data class SavingsAccount2(override val balance: BigDecimal,
                           val interestRate: BigDecimal) : Account2

data class TradingAccount2(override val balance: BigDecimal,
                           val margin: Boolean) : Account2

fun usingExample2() {
  val savings = SavingsAccount2(BigDecimal(105), BigDecimal(0.04))
  val trading = TradingAccount2(BigDecimal(210), true)
  savings.compareTo(trading)
}

interface Account4<E : Account4<E>> : Comparable<E> {
  val balance: BigDecimal
  override fun compareTo(other: E): Int = balance.compareTo(other.balance)
}

data class SavingsAccount4(override val balance: BigDecimal,
                           val interestRate: BigDecimal) : Account4<SavingsAccount4>

data class TradingAccount4(override val balance: BigDecimal,
                           val margin: Boolean) : Account4<TradingAccount4>

fun usingExample4() {
  val savings1 = SavingsAccount4(BigDecimal(105), BigDecimal(0.04))
  val savings2 = SavingsAccount4(BigDecimal(396), BigDecimal(0.05))
  savings1.compareTo(savings2)

  val trading1 = TradingAccount4(BigDecimal(211), true)
  val trading2 = TradingAccount4(BigDecimal(853), false)
  trading1.compareTo(trading2)
  // savings.compareTo(trading) compile error
}