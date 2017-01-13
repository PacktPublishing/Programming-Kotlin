package com.packt.chapter5

sealed class Either<out L, out R> {
  fun <T> fold(lfn: (L) -> T, rfn: (R) -> T): T = when (this) {
    is Left -> lfn(this.value)
    is Right -> rfn(this.value)
  }

  fun leftProjection(): Projection<L> = when (this) {
    is Left -> ValueProjection(this.value)
    is Right -> EmptyProjection<L>()
  }

  fun isLeft() = when (this) {
    is Left -> true
    is Right -> false
  }

  fun rightProjection(): Projection<R> = when (this) {
    is Left -> EmptyProjection<R>()
    is Right -> ValueProjection(this.value)
  }

  fun isRight() = when (this) {
    is Left -> false
    is Right -> true
  }
}

class Left<out L>(val value: L) : Either<L, Nothing>()
class Right<out R>(val value: R) : Either<Nothing, R>()

fun <T> Projection<T>.getOrElse(or: () -> T): T = when (this) {
  is EmptyProjection -> or()
  is ValueProjection -> this.value
}

sealed class Projection<out T> {
  abstract fun <U> map(fn: (T) -> U): Projection<U>
  abstract fun exists(fn: (T) -> Boolean): Boolean
  abstract fun filter(fn: (T) -> Boolean): Projection<T>
  abstract fun toList(): List<T>
  abstract fun orNull(): T?
}

class EmptyProjection<out T> : Projection<T>() {
  override fun <U> map(fn: (T) -> U): Projection<U> = EmptyProjection<U>()
  override fun exists(fn: (T) -> Boolean): Boolean = false
  override fun filter(fn: (T) -> Boolean): Projection<T> = this
  override fun toList(): List<T> = emptyList()
  override fun orNull(): T? = null
}

class ValueProjection<out T>(val value: T) : Projection<T>() {
  override fun <U> map(fn: (T) -> U): Projection<U> = ValueProjection(fn(value))
  override fun exists(fn: (T) -> Boolean): Boolean = fn(value)
  override fun filter(fn: (T) -> Boolean): Projection<T> = when (fn(value)) {
    true -> this
    false -> EmptyProjection()
  }

  override fun toList(): List<T> = listOf(value)
  override fun orNull(): T? = value
}

fun eitherExamples() {

  class User(val name: String, val admin: Boolean)
  class ServiceAccount
  class Address(val town: String, val postcode: String)

  fun getCurrentUser(): Either<ServiceAccount, User> = TODO()
  fun getUserAddresses(user: User): List<Address> = TODO()
  val addresses = getCurrentUser().fold({ emptyList<Address>() }, { getUserAddresses(it) })

  val postcodes = getCurrentUser().rightProjection().map { getUserAddresses(it) }.map { addresses.map { it.postcode } }.getOrElse { emptyList() }

  val service: ServiceAccount? = getCurrentUser().leftProjection().orNull()
  val usersWithMultipleAddresses = getCurrentUser().rightProjection().filter { getUserAddresses(it).size > 1 }
  val isAdmin = getCurrentUser().rightProjection().exists { it.admin }
}