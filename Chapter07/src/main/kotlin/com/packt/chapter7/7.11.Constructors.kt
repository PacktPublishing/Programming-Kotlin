import java.nio.file.FileSystems
import java.sql.Connection
import java.sql.DriverManager
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.KParameter
import kotlin.reflect.jvm.jvmErasure

class Kingdom(name: String, ruler: String, peaceful: Boolean) {
  constructor(name: String, ruler: String) : this(name, ruler, false)
}

fun <T : Any> printConstructors(kclass: KClass<T>) {
  kclass.constructors.forEach {
    println(it.parameters)
  }
}

fun createKingdom1(name: String, ruler: String, peaceful: Boolean): Kingdom {
  val constructor = Kingdom::class.constructors.find { it.parameters.size == 3 } ?: throw RuntimeException("No compatible constructor")
  return constructor.call(name, ruler, peaceful)
}

interface Plugin {
  fun configure(): Unit
}

class OraclePlugin(conn: Connection) {
  fun configure(): Unit = TODO() // run queries on the connection
}

fun createPlugin(className: String): Plugin {

  val kclass = Class.forName(className).kotlin

  assert(kclass.constructors.size == 1, { "Only supply plugins with a single constructor" })
  val constructor = kclass.constructors.first()

  assert(constructor.parameters.size == 1, { "Only supply plugins with one parameter" })
  val parameter: KParameter = constructor.parameters.first()

  val map = when (parameter.type.jvmErasure) {
    java.sql.Connection::class -> {
      val conn = DriverManager.getConnection("jdbc_url")
      mapOf(parameter to conn)
    }
    java.util.Properties::class -> {
      val props = Properties()
      mapOf(parameter to props)
    }
    java.nio.file.FileSystem::class -> {
      val fs = FileSystems.getDefault()
      mapOf(parameter to fs)
    }
    else -> throw RuntimeException("Unsupported type")
  }

  return constructor.callBy(map) as Plugin
}

fun badCreate(): Kingdom {
  val constructor = Kingdom::class.constructors.find { it.parameters.size == 3 } ?: throw RuntimeException("No compatible constructor")
  return constructor.call("", "", "")
}

fun main(args: Array<String>) {
  printConstructors(Kingdom::class)
  createKingdom1("Ashanti Empire", "Prempeh I", true)
  createPlugin(OraclePlugin::class.qualifiedName!!)
  badCreate()
}

