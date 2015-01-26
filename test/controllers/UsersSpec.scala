import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import play.api.libs.json.Json
import play.api.test.Helpers._
import play.api.test.{ FakeApplication, FakeRequest, WithApplication }

@RunWith(classOf[JUnitRunner])
class UsersSpec extends Specification {
  "Users" should {
    "accept new users" in new WithApplication(FakeApplication(additionalConfiguration = Map("message-bus.url" -> "file:tmp/test-data/message-bus"))) {
      val user = Json.obj("firstName" -> "John", "lastName" -> "Doe")
      val request = FakeRequest(POST, "/users").withJsonBody(user)
      val create = call(controllers.Users.create, request)

      status(create) must equalTo(CREATED)
      contentType(create) must beSome.which(_ == "application/json")
      contentAsJson(create) must beEqualTo(user)
    }
  }
}
