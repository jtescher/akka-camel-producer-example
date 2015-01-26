name := """akka-camel-producer-example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.5"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)

// Test Coverage Metrics
ScoverageSbtPlugin.ScoverageKeys.coverageExcludedPackages := "<empty>;Reverse.*;"
