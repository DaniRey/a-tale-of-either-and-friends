ThisBuild / organization := "either.and.friends"
ThisBuild / scalaVersion := "2.13.1"
ThisBuild / version := "0.0.1-SNAPSHOT"

lazy val eitherandfriends = (project in file("."))
  .aggregate(forcomprehensions, consensus, implicits, givens)

lazy val forcomprehensions = (project in file("forcomprehensions"))
  .settings(
    name := "forcomprehensions"
  )

lazy val consensus = (project in file("consensus"))
  .settings(
    name := "consensus"
  )

lazy val implicits = (project in file("implicits"))
  .settings(
    name := "implicits",
    libraryDependencies += "com.typesafe.play" %% "play-json" % "2.8.1"
  )

lazy val givens = (project in file("givens"))
  .settings(
    name := "givens",
    scalaVersion := "0.22.0-RC1"
  )
