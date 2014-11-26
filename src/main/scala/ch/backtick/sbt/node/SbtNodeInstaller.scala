package ch.backtick.sbt.node

import org.slf4j.impl.StaticLoggerBinder
import org.slf4j.impl.StaticLoggerBinder._

import sbt._
import sbt.Keys._

object Import {
  val nodeInstaller = TaskKey[Unit]("node-install", "installs node.js runtime locally")

  object SbtNodeInstallerKeys {
    val nodeVersion = SettingKey[String]("node-version", "node install version")
    val npmVersion = SettingKey[String]("npm-version", "npm install version")
    val nodeDirectory = SettingKey[File]("node-directory", "node.js installation directory")
  }
}

object SbtNodeInstaller extends AutoPlugin {

  override def trigger = AllRequirements

  val autoImport = Import

  import autoImport._
  import SbtNodeInstallerKeys._

  override def projectSettings = Seq(
    nodeVersion := "v0.10.33",
    npmVersion := "2.1.7",
    nodeDirectory := file(".node/"),
    nodeInstaller := {
      StaticLoggerBinder.sbtLogger = streams.value.log
      streams.value.log.info("Checking / Updating node.js installation")
      Node(nodeDirectory.value, nodeVersion.value, npmVersion.value)
    }
  )
}

// core feature implemented here
object Node {
  def apply(nodeDirectory: File, nodeVersion: String, npmVersion: String): Unit = {
    new NodeInstaller(nodeDirectory, nodeVersion, npmVersion)
  }
}