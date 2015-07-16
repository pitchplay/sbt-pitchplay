/* Copyright © 2015 PitchPlay.
 * 
 * See the LICENCE file distributed with this work for additional
 * information regarding copyright ownership.
 */
sbtPlugin := true

organization := "io.pitchplay"
name := "sbt-pitchplay"

homepage := Some(url("https://github.com/pitchplay/sbt-pitchplay"))
licenses := Seq("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html"))
bintrayOrganization := Some("pitchplay")
publishMavenStyle := false

scalaVersion := "2.10.5"

scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked",
  "-Xfatal-warnings",
  "-Xfuture",
  "-Xlint",
  "-Ywarn-dead-code",
  "-Yno-adapted-args",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard"
)

/* Included Plugins */
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.7.0")
addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.4.0")
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.1.0")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.0.1")
addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.0")

/* Scripted */
scriptedSettings
scriptedLaunchOpts := { scriptedLaunchOpts.value ++
  Seq("-Xmx1024M", "-XX:MaxPermSize=256M", "-Dplugin.version=" + version.value)
}
