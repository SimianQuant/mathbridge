import sbtcrossproject.CrossPlugin.autoImport.{crossProject, CrossType}

lazy val mathbridge = crossProject(JVMPlatform, JSPlatform)
  .in(file("."))
  .settings(
    name := "mathbridge",
    organization := "com.simianquant",
    version := Settings.versions.project,
    scalaVersion := Settings.versions.scala,
    scalacOptions ++= List(
      ("-Xlint:adapted-args,nullary-unit,inaccessible,nullary-override,infer-any,doc-detached,private-shadow," +
        "type-parameter-shadow,poly-implicit-overload,option-implicit,delayedinit-select,by-name-right-associative," +
        "package-object-classes,unsound-match,stars-align,constant"),
      "-Ywarn-unused:imports,patvars,privates,locals",
      "-opt:l:method",
      "-Ywarn-unused-import",
      "-deprecation",
      "-unchecked",
      "-explaintypes",
      "-encoding",
      "UTF-8",
      "-feature",
      "-Xlog-reflective-calls",
      "-Ywarn-inaccessible",
      "-Ywarn-infer-any",
      "-Ywarn-nullary-override",
      "-Ywarn-nullary-unit",
      "-Xfuture",
      "-target:jvm-1.8"
    ),
    logBuffered in Test := true,
    testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oD"),
    scalacOptions in (Compile, doc) ++= Seq(
      "-author",
      "-groups",
      "-implicits"
    ),
    libraryDependencies ++= Seq(
      "org.scalatest" %%% "scalatest" % Settings.versions.scalatest % "test",
      "org.scalacheck" %%% "scalacheck" % Settings.versions.scalacheck % "test",
      "org.typelevel" %%% "spire" % Settings.versions.spire
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
    publishMavenStyle := true
  )
  .jvmSettings(
    parallelExecution in Test := true,
    fork := true,
    libraryDependencies += "org.apache.commons" % "commons-math3" % Settings.versions.commonsMath,
    scalacOptions ++= Seq(
      "-Ywarn-dead-code",
      "-Ywarn-value-discard"
    ),
    javaOptions ++= Seq(
      "-d64",
      "-XX:+HeapDumpOnOutOfMemoryError",
      "-XX:+UseG1GC",
      "-XX:+UseStringDeduplication",
      "-Xmx3072m"),
    sourceGenerators in Test += Def.task {
      val file = (sourceManaged in Test).value / "simianquant" / "test" / "mathbridge"
      IO.write(file, Settings.propConstants(1))
      Seq(file)
    }.taskValue
  )
  .jsSettings(
    jsDependencies += ProvidedJS / "math.min.js" commonJSName "math",
    scalaJSUseMainModuleInitializer := true,
    sourceGenerators in Test += Def.task {
      val file = (sourceManaged in Test).value / "simianquant" / "test" / "mathbridge"
      IO.write(file, Settings.propConstants(10))
      Seq(file)
    }.taskValue,
  )

lazy val mathbridgeJVM = mathbridge.jvm
lazy val mathbridgeJS = mathbridge.js

lazy val cleanAll = taskKey[Unit]("Cleans everything")
lazy val compileAll = taskKey[Unit]("Compiles everything")
lazy val testAll = taskKey[Unit]("Tests everything")
lazy val buildCoverage = taskKey[Unit]("Generate coverage report")
lazy val publishLocalSafeAll = taskKey[Unit]("Publishes everything locally")

lazy val releaseCommand = Command.command("release") { state =>
  "cleanAll" :: "testAll" :: "mathbridgeJVM/publishSigned" :: "mathbridgeJS/publishSigned" :: "mathbridgeJVM/sonatypeRelease" :: state
}

cleanAll in ThisBuild := {
  clean.in(mathbridgeJVM).value
  clean.in(mathbridgeJS).value
}

compileAll in ThisBuild := {
  compile.in(mathbridgeJVM, Test).value
  compile.in(mathbridgeJS, Test).value
}

testAll in ThisBuild := {
  test.in(mathbridgeJS, Test).value
  test.in(mathbridgeJVM, Test).value
}

buildCoverage in ThisBuild := Def
  .sequential(
    clean.in(mathbridgeJVM),
    test.in(mathbridgeJVM, Test),
    coverageReport.in(mathbridgeJVM)
  )
  .value

publishLocalSafeAll in ThisBuild := Def
  .sequential(
    cleanAll,
    compileAll,
    testAll,
    publishLocal.in(mathbridgeJVM),
    publishLocal.in(mathbridgeJS)
  )
  .value

commands in ThisBuild += releaseCommand
