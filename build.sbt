sbtPlugin := true

organization := "ch.backtick.sbt"

name := "sbt-node-installer"

version := "0.2.1-SNAPSHOT"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "com.github.eirslett" % "frontend-plugin-core" % "0.0.16" exclude("org.slf4j", "slf4j-simple"),
  "com.github.eirslett" %% "sbt-slf4j" % "0.1"
)