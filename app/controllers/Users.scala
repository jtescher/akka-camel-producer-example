package controllers

import actors.EventStreamProducerActor
import akka.actor.ActorRef
import play.api.libs.concurrent.Akka
import play.api.Play.current
import play.api.mvc.{ Action, BodyParsers, Controller }

object Users extends Controller {

  val eventStreamProducer: ActorRef = Akka.system.actorOf(EventStreamProducerActor.props)

  def create = Action(BodyParsers.parse.json) { request =>
    eventStreamProducer ! request.body.toString.getBytes
    Created(request.body)
  }
}
