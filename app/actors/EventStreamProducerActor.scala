package actors

import akka.actor.{ Actor, Props }
import akka.camel.{ Oneway, Producer }
import play.api.Play

class EventStreamProducerActor extends Actor with Producer with Oneway {
  private val messageBusURL = Play.current.configuration.getString("message-bus.url").get
  def endpointUri = messageBusURL
}

object EventStreamProducerActor {
  def props: Props = Props[EventStreamProducerActor]
}
