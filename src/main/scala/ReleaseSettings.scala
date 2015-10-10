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
import com.timushev.sbt.updates.UpdatesPlugin
import com.timushev.sbt.updates.UpdatesKeys.dependencyUpdatesFailBuild


object ReleaseSettings extends AutoPlugin with ReleaseTasks {

  override def requires = ReleasePlugin && DockerPlugin && UpdatesPlugin
  override def trigger = allRequirements

  object autoImport {
    lazy val ReleaseTasks = io.pitchplay.sbt.ReleaseTasks
  }

  override def projectSettings: Seq[Setting[_]] = Seq(
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
