sbt-pitchplay
=============

[![Travis](https://img.shields.io/travis/pitchplay/sbt-pitchplay.svg?style=flat-square)](https://travis-ci.org/pitchplay/sbt-pitchplay)
[![Codacy](https://img.shields.io/codacy/4e20f68b914641798bc8adb76c2ec6de.svg?style=flat-square)](https://www.codacy.com/app/pitchplay/sbt-pitchplay)
[![VersionEye](https://img.shields.io/versioneye/d/user/projects/55749c0e33633400230000a7.svg?style=flat-square)](https://www.versioneye.com/user/projects/55749c0e33633400230000a7)
[![Maven Central](https://img.shields.io/maven-central/v/io.pitchplay/sbt-pitchplay.svg?style=flat-square)]()

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

Quirks
------

Currently [sbt-buildinfo] needs to be explicitly enabled in the projects
build.sbt file.

Development
-----------

This repository contains a [docker-compose] configuration which will launch
the scripted tests in watch mode.

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
[docker-compose]: https://docs.docker.com/compose
