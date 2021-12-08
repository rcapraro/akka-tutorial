import akka.actor.typed.ActorSystem
import akka.actor.typed.javadsl.Behaviors

import akka.http.scaladsl.Http
import akka.http.scaladsl.model.*
import akka.http.scaladsl.server.Directives.*

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport.*
import spray.json.DefaultJsonProtocol.*

@main def httpServer(): Unit =
  implicit val actorSystem: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "akka-http")
  implicit val userMarshaller: spray.json.RootJsonFormat[User] = jsonFormat3(User.apply)

  val userPath = path("user")
  val helloRoute = get {
    path("hello") {
      complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, "Hello from Akka!"))
    }
  }

  val getUser = get {
    path("user" / LongNumber) {
      userId => complete(User(userId, "TestUser", "test@test.com"))
    }
  }

  val createUser = post {
    userPath {
      entity(as[User]) {
        user => complete(user)
      }
    }
  }

  val updateUser = put {
    userPath {
      entity(as[User]) {
        user => complete(user)
      }
    }
  }

  val deleteUser = delete {
    path("user" / LongNumber) {
      userId => complete(User(userId, "DeletedUser", "test@test.com"))
    }
  }

  Http()
    .newServerAt("127.0.0.1", 8080)
    .bind(concat(helloRoute, getUser, createUser, updateUser, deleteUser))
