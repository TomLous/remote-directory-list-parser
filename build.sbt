name := "remote-directory-list-parser"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= {


  val scalatestVersion = "2.2.4"
  val scalazVersion = "7.2.5"



  Seq(
    "org.scalaz" %% "scalaz-core" % scalazVersion,
    "org.scalatest" %% "scalatest" % scalatestVersion % "test"

  )
}

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-Xlint",
  "-Ywarn-dead-code",
  "-language:_",
  "-target:jvm-1.8",
  "-encoding", "UTF-8"
)

mainClass in(Compile, run) := Some("com.datlinq.Main")