import sbt._
import Keys._

object Publish {
  def publishJfrog = Seq(
    // maven style should only be used for libraries, not for plugins
    publishMavenStyle := true,
  
    publishTo := {
      val jfrog = "https://lcdp.jfrog.io/artifactory/"
      if (isSnapshot.value)
        Some("Artifactory Realm" at jfrog + "sbt-dev")
      else
        Some("Artifactory Realm"  at jfrog + "sbt-release")
    },
    
    credentials += Credentials(Path.userHome / ".sbt" / ".credentials")
  )

}