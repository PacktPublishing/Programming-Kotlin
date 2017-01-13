package com.packt.chapter5

class Student(val name: String, val studentNumber: String, val email: String)

sealed class Validation {
  abstract infix operator fun plus(other: Validation): Validation
  abstract fun <T> getOrElse(t: T, or: (List<String>) -> T): T
}

class Invalid(val errors: List<String>) : Validation() {

  override fun plus(other: Validation): Validation = when (other) {
    is Invalid -> Invalid(this.errors + other.errors)
    is Valid -> this
  }

  override fun <T> getOrElse(t: T, or: (List<String>) -> T): T = or(errors)

  companion object {
    operator fun invoke(error: String) = Invalid(listOf(error))
  }
}

object Valid : Validation() {

  override fun plus(other: Validation): Validation = when (other) {
    is Invalid -> other
    is Valid -> this
  }

  override fun <T> getOrElse(t: T, or: (List<String>) -> T): T = t
}

fun isValidName(name: String): Validation {
  return if (name.trim().length > 2)
    Valid
  else
    Invalid("Name $name is too short")
}

fun isValidStudentNumber(studentNumber: String): Validation {
  return if (studentNumber.all { Character.isDigit(it) })
    Valid
  else
    Invalid("Student number must be only digits: $studentNumber")
}

fun isValidEmailAddress(email: String): Validation {
  return if (email.contains("@"))
    Valid
  else
    Invalid("Email must contain an '@' symbol")
}

fun validateStudent(student: Student) {

  val validation = isValidName(student.name) +
      isValidStudentNumber(student.studentNumber) +
      isValidEmailAddress(student.email)

  validation.getOrElse(student, { throw RuntimeException("Error creating student. The errors are $it") })
}
