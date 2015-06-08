/* Copyright © 2015 PitchPlay Inc.
 *
 * See the LICENCE file distributed with this work for additional
 * information regarding copyright ownership.
 */
package io.pitchplay.sbt

import sbt._
import sbt.Keys._
import sbtrelease.ReleasePlugin
import sbtrelease.ReleasePlugin.autoImport.{releaseProcess, ReleaseStep}
import sbtrelease.ReleaseStateTransformations._
import com.typesafe.sbt.packager.Keys._
import com.typesafe.sbt.packager.docker.DockerPlugin
import com.typesafe.sbt.packager.docker.DockerPlugin.autoImport.Docker


object ReleaseSettings extends AutoPlugin with ReleaseTasks {

  override def requires = ReleasePlugin && DockerPlugin
  override def trigger = allRequirements

  override def projectSettings = Seq(
    releaseProcess := release,
    dockerRepository in Docker := Some("pitchplay"),
    dockerBaseImage in Docker := "java:8-jre"
  )

  /** Steps to perform to run a release */
  private[this] lazy val release: Seq[ReleaseStep] = Seq(
    masterCheck,
    checkSnapshotDependencies,
    inquireVersions,
    setReleaseVersion,
    commitReleaseVersion,
    tagRelease,
    dockerRelease,
    setNextVersion,
    commitNextVersion,
    pushChanges
  )

}
