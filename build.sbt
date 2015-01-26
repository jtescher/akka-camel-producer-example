name := """akka-camel-producer-example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.5"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-camel" % "2.3.8",
  "org.apache.camel" % "camel-rabbitmq" % "2.14.1",
  cache,
  ws
)

// Test Coverage Metrics
ScoverageSbtPlugin.ScoverageKeys.coverageExcludedPackages := "<empty>;Reverse.*;"
