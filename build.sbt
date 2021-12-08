ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.0"

lazy val root = (project in file("."))
  .settings(
    name := "akka-tutorial",
    libraryDependencies ++= Seq(
      ("com.typesafe.akka" % "akka-actor-typed" % "2.6.17").cross(CrossVersion.for3Use2_13),
      ("com.typesafe.akka" % "akka-stream-typed" % "2.6.17").cross(CrossVersion.for3Use2_13),
      ("com.typesafe.akka" % "akka-http" % "10.2.6").cross(CrossVersion.for3Use2_13),
      ("com.typesafe.akka" % "akka-http-spray-json" % "10.2.6").cross(CrossVersion.for3Use2_13)
    )
  )
