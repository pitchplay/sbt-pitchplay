sbt-pitchplay
=============

[![Travis](https://img.shields.io/travis/pitchplay/sbt-pitchplay.svg?style=flat-square)](https://travis-ci.org/pitchplay/sbt-pitchplay)

Common settings, plugins and configurations used in PitchPlay development.

Plugins
-------

The following plugins are included by using this plugin:

  * [sbt-buildinfo]: Creates a buildinfo object for use in projects
  * [sbt-native-packager]: Docker support
  * [sbt-scalastyle]: Code linting
  * [sbt-scoverage]: Code coverage
  * [sbt-release]: Defines and automates release process

In order to leverage the sbt-scalastyle plugin, a [scalastyle_config.xml] file
will need to be placed in the root of the project.

See each individual plugin for additional overrides and settings if needed.

License
-------

This product is licensed under the Apache-2.0 license. See the corresponding
LICENSE and NOTICE files for further information.

[scalastyle_config.xml]: http://www.scalastyle.org/scalastyle_config.xml
[sbt-release]: https://github.com/sbt/sbt-release
[sbt-scalastyle]: https://github.com/scalastyle/scalastyle-sbt-plugin
[sbt-scoverage]: https://github.com/scoverage/sbt-scoverage
[sbt-native-packager]: https://github.com/sbt/sbt-native-packager
[sbt-buildinfo]: https://github.com/sbt/sbt-buildinfo