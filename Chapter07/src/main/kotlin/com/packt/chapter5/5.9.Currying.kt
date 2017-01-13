import java.util.logging.Level

fun <P1, P2, R> Function2<P1, P2, R>.curried(): (P1) -> (P2) -> R =
    { p1 ->
      { p2 ->
        this(p1, p2)
      }
    }

fun <P1, P2, P3, R> Function3<P1, P2, P3, R>.curried(): (P1) -> (P2) -> (P3) -> R =
    { p1 ->
      { p2 ->
        { p3 ->
          this(p1, p2, p3)
        }
      }
    }

fun logger(level: Level, appender: Appendable, msg: String): Nothing = TODO()

fun curryExample() {
  val logger: (Level) -> (Appendable) -> (String) -> Unit = ::logger.curried()
  val logger2: (Appendable) -> (String) -> Unit = logger(Level.SEVERE)
  val logger3: (String) -> Unit = logger2(System.out)
  logger3("my message")
}