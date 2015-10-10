import ReleaseTasks._
import ReleaseTransformations._

releaseProcess := Seq(
  masterCheck,
  checkSnapshotDependencies,
  dependencyCheck,
  inquireVersions,
  runClean,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  publishArtifacts,
  setNextVersion,
  commitNextVersion,
  pushChanges
)
