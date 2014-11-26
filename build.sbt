sbtPlugin := true

organization := "ch.backtick.sbt"

name := "sbt-node-installer"

version := "0.2.2-SNAPSHOT"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "com.github.eirslett" % "frontend-plugin-core" % "0.0.16"
)