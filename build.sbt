import com.typesafe.sbt.osgi.OsgiKeys
import sbt.Keys.organization

Global / scalaVersion := "2.13.0"

lazy val main = (project in file("."))
  .enablePlugins(SbtOsgi)
  .settings(osgiSettings)
  .settings(
    name := "examplebinding",
    organization := "org.openhab.binding",
    version := "0.0.2",
    resolvers ++= Seq(
      "Openhab Bintray" at "https://dl.bintray.com/openhab/mvn",
      "Openhab Artifactory" at "https://openhab.jfrog.io/openhab/libs-release",
      "Eclipse Smarthome" at "http://eclipse.github.io/smarthome/third-party/m2-repo/"
    ),
    libraryDependencies ++= Seq(
      "org.openhab.distro" % "openhab-addons" % "2.4.0" % "provided",
      "org.osgi" % "org.osgi.service.component" % "1.4.0" % "provided",
      "org.osgi" % "org.osgi.service.component.annotations" % "1.4.0" % "provided",
      "org.eclipse.jdt" % "org.eclipse.jdt.annotation" % "2.1.150" % "provided"
    ).map(_ exclude("org.eclipse.smarthome.test", "*")),
    libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.26" % "provided",
    OsgiKeys.exportPackage := Seq("org.openhab.binding.examplebinding"),
  ).aggregate(scalaBundle)

lazy val scalaBundle = (project in file("bundles") / "scala-library")
  .enablePlugins(SbtOsgi)
  .settings(osgiSettings)
  .settings(
    name := "scala-library",
    version := scalaVersion.value,
    OsgiKeys.exportPackage := Seq("scala.*"),
    OsgiKeys.additionalHeaders := Map("Bundle-ActivationPolicy" -> "lazy"),
    libraryDependencies += "org.scala-lang" % "scala-library" % scalaVersion.value,
  )
