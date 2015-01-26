package controllers

import play.api.mvc.{ Action, BodyParsers, Controller }

object Users extends Controller {

  def create = Action(BodyParsers.parse.json) { request =>
    Created(request.body)
  }
}
