/* Copyright © 2015 PitchPlay Inc.
 *
 * See the LICENCE file distributed with this work for additional
 * information regarding copyright ownership.
 */
package io.pitchplay.sbt

import sbt._
import sbt.Keys._
import bintray.BintrayKeys._

object BaseSettings extends AutoPlugin {
  override def trigger = allRequirements

  override def projectSettings: Seq[Setting[_]] = Seq(
    organization := "io.pitchplay",
    bintrayOrganization := Some("pitchplay"),
    scalaVersion := "2.11.6",
    scalacOptions ++= Seq(
      "-deprecation",         // Warn on deprecated API's
      "-feature",             // Explicit feature checking
      "-unchecked",           // Show unchecked warnings
      //"-target:jvm-1.8",      // Java 8
      "-Xfatal-warnings",     // Fail build on warnings
      "-Xfuture",             // Strict class-file format checks
      "-Xlint",               // Additional lint warnings
      "-Ywarn-dead-code",     // Warn on dead code
      "-Yno-adapted-args",    // Disable auto-tupling
      "-Ywarn-numeric-widen", // Warn when numerics are widened.
      "-Ywarn-value-discard"  // Warn when non-Unit expression results are unused
    ),
    updateOptions := updateOptions.value.withCachedResolution(true)
  )
}
