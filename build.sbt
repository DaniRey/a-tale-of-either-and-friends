ThisBuild / organization := "either.and.friends"
ThisBuild / scalaVersion := "2.13.1"
ThisBuild / version      := "0.0.1-SNAPSHOT"

lazy val eitherandfriends = (project in file("."))
  .aggregate(forcomprehensions, consensus)

lazy val forcomprehensions = (project in file("forcomprehensions"))
  .settings(
    name := "forcomprehensions"
  )

lazy val consensus = (project in file("consensus"))
  .settings(
    name := "consensus"
  )
	
