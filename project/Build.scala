import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "playtrial"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean,
    "mysql" % "mysql-connector-java" % "5.1.30",
    "org.apache.nutch" % "nutch" % "2.3.1"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
