/* Copyright © 2015 PitchPlay Inc.
 *
 * See the LICENCE file distributed with this work for additional
 * information regarding copyright ownership.
 */

package io.pitchplay.sbt

import sbt._
import sbt.Keys._

object LibraryVersions extends AutoPlugin {

  override def trigger = allRequirements

  object autoImport {
    val libraryVersions = settingKey[Map[Symbol, String]]("Versions of libraries used in dependencies")
  }

  import autoImport._

  override def projectSettings: Seq[Setting[_]] = Seq(
    libraryVersions := Map(
      'scalacheck -> "1.12.5",
      'scalatest -> "2.2.5"
    )
  )
}
