/* Copyright © 2015 PitchPlay.
 * 
 * See the LICENCE file distributed with this work for additional
 * information regarding copyright ownership.
 */
sbtPlugin := true

organization := "io.pitchplay"
name := "sbt-pitchplay"

scalaVersion := "2.10.4"

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

// Included Plugins
// Build
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.7.0")
addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.4.0")

// Test
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.1.0")

// Release
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.0.1")
addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.0")

scriptedSettings
scriptedLaunchOpts := { scriptedLaunchOpts.value ++
  Seq("-Xmx1024M", "-XX:MaxPermSize=256M", "-Dplugin.version=" + version.value)
}
