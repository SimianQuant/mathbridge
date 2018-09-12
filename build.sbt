import sbtcrossproject.CrossPlugin.autoImport.{crossProject, CrossType}

lazy val mathbridge = crossProject(JVMPlatform, JSPlatform)
  .crossType(CrossType.Pure)
  .in(file("."))
  .settings(
    name := "mathbridge",
    organization := "com.simianquant",
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
    scalacOptions ++= {
      List(
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
      )
    },
    logBuffered in Test := true,
    testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oD"),
    scalacOptions in (Compile, doc) ++= Seq(
      "-author",
      "-groups",
      "-implicits"
    )
  )
  .jvmSettings(
    parallelExecution in Test := true,
    fork := true,
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
  )
  .jsSettings(
    scalaJSUseMainModuleInitializer in Test := false,
    scalaJSStage in Test := FullOptStage,
  )

lazy val mathbridgeJVM = mathbridge.jvm
lazy val mathbridgeJS = mathbridge.js
