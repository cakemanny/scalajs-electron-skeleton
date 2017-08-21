import java.nio.charset.Charset

enablePlugins(ScalaJSPlugin)

name := "Scala.js Electron Skeleton"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.3",
  "be.doeraene" %%% "scalajs-jquery" % "0.9.2"
)

scalacOptions += "-deprecation"
scalacOptions += "-feature"

// Be a module so that our main.js can require us
scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
scalaJSUseMainModuleInitializer := false

val electronMain = TaskKey[File]("electron-main", "Generate Electron application's main file.")

electronMain := {
  val scalaMainPath = baseDirectory.value / ".." / "electron-app" / "scala-main.js"
  IO.copyFile((fastOptJS in Compile).value.data, scalaMainPath)
  scalaMainPath
}
