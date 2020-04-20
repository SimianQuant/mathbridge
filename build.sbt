lazy val mathbridge = project
  .in(file("."))
  .settings(
    name := "mathbridge",
    organization := "com.simianquant",
    version := Settings.versions.project,
    scalaVersion := Settings.versions.scala,
    scalacOptions ++= List(
      ("-Xlint:adapted-args,nullary-unit,inaccessible,nullary-override,infer-any,doc-detached,private-shadow," +
        "type-parameter-shadow,poly-implicit-overload,option-implicit,delayedinit-select," +
        "package-object-classes,stars-align,constant"),
      "-Ywarn-unused:imports,patvars,privates,locals",
      "-opt:l:method",
      "-deprecation",
      "-unchecked",
      "-explaintypes",
      "-encoding",
      "UTF-8",
      "-feature",
      "-Xlog-reflective-calls",
      "-Ywarn-dead-code",
      "-Ywarn-value-discard"
    ),
    logBuffered in Test := true,
    testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oD"),
    scalacOptions in (Compile, doc) ++= Seq(
      "-author",
      "-groups",
      "-implicits"
    ),
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % Settings.versions.scalatest % "test",
      "org.scalacheck" %% "scalacheck" % Settings.versions.scalacheck % "test",
      "org.typelevel" %% "spire" % Settings.versions.spire
    ),
    scmInfo := Some(
      ScmInfo(
        url("https://github.com/SimianQuant/mathbridge"),
        "scm:git@github.com:SimianQuant/mathbridge.git"
      )
    ),
    developers := List(
      Developer(
        id = "harshad-deo",
        name = "Harshad Deo",
        email = "harshad@simianquant.com",
        url = url("https://github.com/harshad-deo")
      )
    ),
    description := "A bridge to shareable mathematical functions",
    licenses := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt")),
    homepage := Some(url("https://github.com/SimianQuant/mathbridge")),
    pomIncludeRepository := { _ =>
      false
    },
    publishTo := {
      val nexus = "https://oss.sonatype.org/"
      if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
      else Some("releases" at nexus + "service/local/staging/deploy/maven2")
    },
    publishMavenStyle := true,
    parallelExecution in Test := true,
    fork := true,
    libraryDependencies += "org.apache.commons" % "commons-math3" % Settings.versions.commonsMath,
  )

lazy val testAll = taskKey[Unit]("Tests everything")
lazy val buildCoverage = taskKey[Unit]("Generate coverage report")
lazy val publishLocalSafeAll = taskKey[Unit]("Publishes everything locally")

lazy val releaseCommand = Command.command("release") { state =>
  "clean" :: "test" :: "publishSigned" :: "sonatypeRelease" :: state
}

buildCoverage in ThisBuild := Def
  .sequential(
    clean.in(mathbridge),
    test.in(mathbridge, Test),
    coverageReport.in(mathbridge)
  )
  .value

publishLocalSafeAll in ThisBuild := Def
  .sequential(
    clean,
    compile,
    test,
    publishLocal
  )
  .value

commands in ThisBuild += releaseCommand
