package com.programming.kotlin.chapter12.hello.api

import akka.util.ByteString
import com.lightbend.lagom.javadsl.api.deser.MessageSerializer
import com.lightbend.lagom.javadsl.api.deser.SerializationException
import com.lightbend.lagom.javadsl.api.deser.StrictMessageSerializer
import com.lightbend.lagom.javadsl.api.transport.MessageProtocol
import com.lightbend.lagom.javadsl.api.transport.NotAcceptable
import com.lightbend.lagom.javadsl.api.transport.UnsupportedMediaType

class GreetingMessageSerializer : StrictMessageSerializer<GreetingMessage> {

  internal var serializer: MessageSerializer.NegotiatedSerializer<GreetingMessage, ByteString> = object : MessageSerializer.NegotiatedSerializer<GreetingMessage, ByteString> {
    override fun protocol(): MessageProtocol {
      return MessageProtocol().withContentType("application/json")
    }

    @Throws(SerializationException::class)
    override fun serialize(messageEntity: GreetingMessage): ByteString {
      return ByteString.fromArray(Jackson.mapper.writeValueAsBytes(messageEntity))
    }
  }

  internal var deserializer = MessageSerializer.NegotiatedDeserializer<GreetingMessage, ByteString> { bytes ->
    Jackson.mapper.readValue(bytes.iterator().asInputStream(), GreetingMessage::class.java)
  }


  override fun serializerForRequest(): MessageSerializer.NegotiatedSerializer<GreetingMessage, ByteString> = serializer

  @Throws(UnsupportedMediaType::class)
  override fun deserializer(protocol: MessageProtocol): MessageSerializer.NegotiatedDeserializer<GreetingMessage, ByteString> = deserializer


  @Throws(NotAcceptable::class)
  override fun serializerForResponse(acceptedMessageProtocols: List<MessageProtocol>): MessageSerializer.NegotiatedSerializer<GreetingMessage, ByteString> = serializer

}
