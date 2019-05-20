import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.io.InputStream

fun main() {
  runBlocking {
    val bytes = withContext(Dispatchers.IO) {
      javaClass.getResourceAsStream("/largefile.csv").readAllBytes()
    }
    println("Bytes read")
  }
}

fun InputStream.readAllBytes(): ByteArray {
  val buffer = ByteArrayOutputStream()
  var byte = read()
  while (byte != -1) {
    buffer.write(byte)
    byte = read()
  }
  return buffer.toByteArray()
}
