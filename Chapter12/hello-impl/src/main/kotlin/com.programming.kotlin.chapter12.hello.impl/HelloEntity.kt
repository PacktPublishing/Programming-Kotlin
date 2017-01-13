package com.programming.kotlin.chapter12.hello.impl

import akka.Done
import com.lightbend.lagom.javadsl.persistence.PersistentEntity
import java.time.LocalDateTime
import java.util.*

class HelloEntity : PersistentEntity<HelloCommand, HelloEvent, HelloState>() {

  /**
   * An entity can define different behaviours for different states, but it will
   * always start with an initial behaviour. This entity only has one behaviour.
   */
  override fun initialBehavior(snapshotState: Optional<HelloState>): PersistentEntity<HelloCommand, HelloEvent, HelloState>.Behavior {

    /*
     * Behaviour is defined using a behaviour builder. The behaviour builder
     * starts with a state, if this entity supports snapshotting (an
     * optimisation that allows the state itself to be persisted to combine many
     * events into one), then the passed in snapshotState may have a value that
     * can be used.
     *
     * Otherwise, the default state is to use the Hello greeting.
     */
    val b = newBehaviorBuilder(snapshotState.orElse(HelloState("Hello", LocalDateTime.now().toString())))

    /*
    * Command handler for the UseGreetingMessage command.
    */
    b.setCommandHandler(
        UseGreetingMessage::class.java,
        { cmd, ctx ->
          // In response to this command, we want to first persist it as a GreetingMessageChanged event
          ctx.thenPersist(
              GreetingMessageChanged(cmd.message),
              { evt -> ctx.reply(Done.getInstance()) })
        }
    )

    /*
     * Event handler for the GreetingMessageChanged event.
     */
    b.setEventHandler(GreetingMessageChanged::class.java,
        // We simply update the current state to use the greeting message from the event.
        { evt -> HelloState(evt.message, LocalDateTime.now().toString()) }
    )

    /*
     * Command handler for the Hello command.
     */
    b.setReadOnlyCommandHandler(Hello::class.java,
        // Get the greeting from the current state, and prepend it to the name
        // that we're sending a greeting to, and reply with that message.
        { cmd, ctx -> ctx.reply(state().message + ", " + cmd.name + "!") }
    )

    /*
     * We've defined all our behaviour, so build and return it.
     */
    return b.build()
  }
}
