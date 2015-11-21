/* Copyright © 2015 PitchPlay Inc.
 *
 * See the LICENCE file distributed with this work for additional
 * information regarding copyright ownership.
 */

package io.pitchplay.sbt

import sbt._
import sbt.Keys._
import com.typesafe.sbt.SbtScalariform.{ ScalariformKeys, scalariformSettings }
import scalariform.formatter.preferences._

object CodeFormat extends AutoPlugin {
  override def trigger = allRequirements

  private[this] lazy val customScalariformSettings = Seq(
    ScalariformKeys.preferences := ScalariformKeys.preferences.value
      .setPreference(FormatXml, false)
      .setPreference(DoubleIndentClassDeclaration, false)
      .setPreference(AlignArguments, true)
      .setPreference(AlignParameters, true)
      .setPreference(AlignSingleLineCaseStatements, true)
      .setPreference(DoubleIndentClassDeclaration, true)
  )

  override def projectSettings: Seq[Setting[_]] =
    scalariformSettings ++ customScalariformSettings
}
