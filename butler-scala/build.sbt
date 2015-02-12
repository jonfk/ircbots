name := """butler-scala"""

version := "1.0"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.6",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.6" % "test",
  "org.scalatest" %% "scalatest" % "2.1.6" % "test",
  "org.pircbotx" % "pircbotx" % "2.0.1",
  "org.slf4j" % "slf4j-api" % "1.7.10",
  "org.slf4j" % "slf4j-simple" % "1.6.4"
)

lazy val logback = "ch.qos.logback" % "logback-classic" % "1.0.0" % "runtime"