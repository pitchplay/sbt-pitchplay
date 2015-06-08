import io.pitchplay.sbt.ReleaseTasks

name := "release test"

releaseProcess := Seq(
  ReleaseTasks.masterCheck
)
