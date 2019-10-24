enablePlugins(ScalaJSPlugin, WorkbenchPlugin, ShoconPlugin)

organization := "com.github.yuxiliu1995"

name := "wigner"

version := "0.1-SNAPSHOT"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.7",
  "com.lihaoyi" %%% "scalatags" % "0.7.0",
  "org.akka-js" %%% "shocon" % "0.4.1"
)

// Add dependency on SHOCON file generation task
compile in Compile := (compile in Compile).dependsOn(shoconConcat).value
