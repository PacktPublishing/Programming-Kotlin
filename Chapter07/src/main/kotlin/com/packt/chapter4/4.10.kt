import java.math.BigDecimal

class InfixExample {
  infix fun concat(other:String) = this.toString() + other
}

fun standalone() {
  val sum = 1 + 2

  val account = Account()
  account.add(100.00)

  val account2 = InfixAccount()
  account2 add 100.00
}


class Account {
  var balance = 0.0
  fun add(amount: Double): Unit {
    this.balance = balance + amount
  }
}


class InfixAccount {
  var balance = 0.0
  infix fun add(amount: Double): Unit {
    this.balance = balance + amount
  }
}