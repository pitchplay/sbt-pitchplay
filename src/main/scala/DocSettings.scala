/* Copyright © 2015 PitchPlay Inc.
 *
 * See the LICENCE file distributed with this work for additional
 * information regarding copyright ownership.
 */
package io.pitchplay.sbt

import sbt._
import sbt.Keys._

object DocSettings extends AutoPlugin {
  override def projectSettings = Seq(
    autoAPIMappings := true
  )
}
