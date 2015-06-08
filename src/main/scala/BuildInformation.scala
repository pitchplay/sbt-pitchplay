/* Copyright © 2015 PitchPlay Inc.
 *
 * See the LICENCE file distributed with this work for additional
 * information regarding copyright ownership.
 */
package io.pitchplay.sbt

import sbt._
import sbt.Keys._
import sbtbuildinfo._
import sbtbuildinfo.BuildInfoKeys._

object BuildInformation extends AutoPlugin {

  override def requires = BuildInfoPlugin
  override def trigger = allRequirements

  private[this] lazy val buildKeys: Seq[BuildInfoKey] = Seq(
    name,
    version,
    scalaVersion,
    sbtVersion,
    BuildInfoKey.action("buildtime") {
      System.currentTimeMillis
    },
    BuildInfoKey.action("buildhost") {
      (Process("bash" :: "-c" :: "hostname" :: Nil).!!).trim
    },
    BuildInfoKey.action("gitsha") {
      (Process("bash" :: "-c" :: "git rev-parse HEAD || echo None" :: Nil).!!).trim
    }
  )

  override def projectSettings = Seq(
    buildInfoKeys := buildKeys
  )

}
