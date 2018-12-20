import sbtcrossproject.CrossPlugin.autoImport.{crossProject, CrossType}

lazy val mathbridge = crossProject(JVMPlatform, JSPlatform)
  .in(file("."))
  .settings(
    name := "mathbridge",
    organization := "com.simianquant.mathbridge",
    version := Settings.versions.project,
    scalaVersion := Settings.versions.scala,
    wartremoverErrors in (Compile, compile) ++= Seq(
      Wart.ArrayEquals,
      Wart.Any,
      Wart.AnyVal,
      Wart.EitherProjectionPartial,
      Wart.Enumeration,
      Wart.Equals,
      Wart.ExplicitImplicitTypes,
      Wart.JavaConversions,
      Wart.JavaSerializable,
      Wart.Null,
      Wart.Option2Iterable,
      Wart.OptionPartial,
      Wart.Product,
      Wart.PublicInference,
      Wart.Return,
      Wart.Serializable,
      Wart.StringPlusAny,
      Wart.Throw,
      Wart.TraversableOps,
      Wart.TryPartial
    ),
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
    publishArtifact in (Compile, packageBin) := true,
    publishArtifact in (Compile, packageDoc) := true,
    publishArtifact in (Compile, packageSrc) := false,
    publishArtifact in (Test, packageBin) := false,
    publishArtifact in (Test, packageDoc) := false,
    publishArtifact in (Test, packageSrc) := false
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
    scalaJSStage in Test := FullOptStage,
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
lazy val publishLocalSafeAll = taskKey[Unit]("Publishes everything locally")

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

publishLocalSafeAll in ThisBuild := Def
  .sequential(
    cleanAll,
    compileAll,
    testAll,
    publishLocal.in(mathbridgeJVM),
    publishLocal.in(mathbridgeJS)
  )
  .value
