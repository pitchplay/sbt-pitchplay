/* Copyright © 2015 PitchPlay Inc.
 *
 * See the LICENCE file distributed with this work for additional
 * information regarding copyright ownership.
 */
package io.pitchplay.sbt

import sbt.{ Project, State }
import sbt.Keys.{ publish, thisProjectRef }
import sbtrelease.ReleasePlugin.autoImport.{ ReleaseStep, releaseVcs }
import com.typesafe.sbt.packager.docker.DockerPlugin.autoImport.Docker
import com.timushev.sbt.updates.UpdatesKeys.{ dependencyUpdates, dependencyUpdatesFailBuild }

trait ReleaseTasks {

  /** Publish to Docker registry */
  lazy val dockerRelease: ReleaseStep = { st: State =>
    val extracted = Project.extract(st)
    val ref = extracted.get(thisProjectRef)
    extracted.runAggregated(publish in Docker in ref, st)
  }

  /** Sanity check that the release is being run on the Master branch */
  lazy val masterCheck: ReleaseStep = { st: State =>
    val extracted = Project.extract(st)
    val vcs = extracted.get(releaseVcs).getOrElse(
      sys.error("Aborting release. Working directory is not a recognized VCS.")
    )
    if (vcs.currentBranch != "master")
      sys.error("Aborting release. Not on master branch.")
    st
  }

  /** Ensure all dependencies are up to date for release  */
  lazy val dependencyCheck: ReleaseStep = { st0: State =>
    val ext = Project.extract(st0)
    val st1 = ext.append(Seq(dependencyUpdatesFailBuild := true), st0)
    val extracted = Project.extract(st1)
    val ref = extracted.get(thisProjectRef)
    extracted.runAggregated(dependencyUpdates in ref, st1)
  }

}

object ReleaseTasks extends ReleaseTasks
