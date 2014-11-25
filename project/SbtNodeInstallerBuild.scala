import sbt.Keys._
import sbt._

object SbtNodeInstallerBuild extends Build {
  lazy val root = Project(id = "sbt-node-installer", base = file(".")) dependsOn(lib)

  lazy val lib = Project(id = "frontend-plugin-core",
    base = file("frontend-plugin-core"),
    settings = Project.defaultSettings ++ Seq(
      libraryDependencies ++= Seq(
        "org.codehaus.jackson" % "jackson-mapper-asl" % "1.9.13",
        "org.apache.commons" % "commons-compress" % "1.5",
        "commons-io" % "commons-io" % "1.3.2",
        "org.apache.httpcomponents" % "httpclient" % "4.3.1",
        "org.slf4j" % "slf4j-api" % "1.7.5"
      )
    )
  )
}