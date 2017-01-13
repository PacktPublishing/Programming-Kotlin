interface Marshaller<out T> {
  fun marshall(json: String): T?
}

object NoopMarshaller : Marshaller<Nothing> {
  override fun marshall(json: String) = null
}