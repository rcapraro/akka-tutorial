ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.0"

lazy val root = (project in file("."))
  .settings(
    name := "akka-tutorial",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" % "akka-actor-typed_2.13" % "2.6.17",
      "com.typesafe.akka" % "akka-stream-typed_2.13" % "2.6.17",
      "com.typesafe.akka" % "akka-http_2.13" % "10.2.6",
      "com.typesafe.akka" % "akka-http-spray-json_2.13" % "10.2.6"
    )
  )
