fun multiprint(vararg strings: String): Unit {
  for (string in strings)
    println(strings)
}

fun multiprint2(prefix: String, vararg strings: String): Unit {
  println(prefix)
  for (string in strings)
    println(string)
}

fun multiprint3(prefix: String, vararg strings: String, suffix: String): Unit {
  println(prefix)
  for (string in strings)
    println(string)
  println(suffix)
}

fun varargusage() {
  multiprint("a", "b", "c")
  multiprint2("Letters", "a", "b", "c", "Finished")
  multiprint3("Start", "a", "b", "c", suffix = "End")
}

fun spreadexample() {
  val strings = arrayOf("a", "b", "c", "d", "e")
  multiprint3("Start", *strings, suffix = "End")
}