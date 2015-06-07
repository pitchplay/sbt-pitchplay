/* Copyright © 2015 PitchPlay Inc.
 *
 * See the LICENCE file distributed with this work for additional
 * information regarding copyright ownership.
 */
package io.pitchplay.sbt

import sbt._
import sbt.Keys._
import sbtrelease.ReleasePlugin
import sbtrelease.ReleasePlugin.autoImport._
import sbtrelease.ReleaseStateTransformations._
import com.typesafe.sbt.packager.Keys._
import com.typesafe.sbt.packager.docker.DockerPlugin.autoImport.Docker

object ReleaseSettings extends AutoPlugin {

  override def requires = ReleasePlugin
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

  /** Publish to Docker registry */
  private[this] lazy val dockerRelease: ReleaseStep = { st: State =>
    val extracted = Project.extract(st)
    val ref = extracted.get(thisProjectRef)
    extracted.runAggregated(publish in Docker in ref, st)
  }

  /** Sanity check that the release is being run on the Master branch */
  private[this] lazy val masterCheck: ReleaseStep = { st: State =>
    val extracted = Project.extract(st)
    val vcs = extracted.get(releaseVcs).getOrElse(
      sys.error("Aborting release. Working directory is not a recognized VCS.")
    )
    if (vcs.currentBranch != "master")
      sys.error("Aborting release. Not on master branch.")
    st
  }


}
