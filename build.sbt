ThisBuild / tlBaseVersion := "0.0"

ThisBuild / organization := "com.armanbilge"
ThisBuild / organizationName := "Arman Bilge"
ThisBuild / developers += tlGitHubDev("armanbilge", "Arman Bilge")
ThisBuild / startYear := Some(2022)
ThisBuild / tlSonatypeUseLegacyHost := false

ThisBuild / crossScalaVersions := Seq("3.2.1", "2.13.10")

ThisBuild / githubWorkflowJavaVersions := Seq(JavaSpec.temurin("17"))
ThisBuild / githubWorkflowOSes := Seq("ubuntu-22.04", "macos-12")

val ceVersion = "3.5-9ba870f"
val ip4sVersion = "3.2.0"
val munitCEVersion = "2.0.0-M3"

lazy val root = tlCrossRootProject.aggregate(`c-ares`)

lazy val `c-ares` = project
  .in(file("c-ares"))
  .enablePlugins(ScalaNativePlugin, ScalaNativeBrewedConfigPlugin)
  .settings(
    name := "ip4s-c-ares",
    libraryDependencies ++= Seq(
      "org.typelevel" %%% "cats-effect" % ceVersion,
      "com.comcast" %%% "ip4s-core" % ip4sVersion,
      "org.typelevel" %%% "munit-cats-effect" % munitCEVersion % Test
    ),
    nativeBrewFormulas += "c-ares",
    Test / testOptions += Tests.Argument("+l")
  )
