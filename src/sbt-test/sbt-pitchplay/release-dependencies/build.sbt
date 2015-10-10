name := "release test"

import ReleaseTasks._

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4"

releaseProcess := Seq(
  dependencyCheck
)
