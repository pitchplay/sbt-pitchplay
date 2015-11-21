logLevel := Level.Warn

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"

addSbtPlugin("me.lessis"         %  "bintray-sbt"           % "0.3.0")
addSbtPlugin("com.timushev.sbt"  %  "sbt-updates"           % "0.1.9")
addSbtPlugin("com.github.gseitz" %  "sbt-release"           % "1.0.1")
addSbtPlugin("org.scalastyle"    %% "scalastyle-sbt-plugin" % "0.7.0")
addSbtPlugin("com.eed3si9n"      %  "sbt-buildinfo"         % "0.5.0")
addSbtPlugin("com.typesafe.sbt"  %  "sbt-native-packager"   % "1.0.4")
addSbtPlugin("org.scalariform"   %  "sbt-scalariform"       % "1.5.1")

// Use sbt-pitchplay as a plugin for sbt-pitchplay
unmanagedSourceDirectories in Compile += baseDirectory.value.getParentFile / "src" / "main" / "scala"
