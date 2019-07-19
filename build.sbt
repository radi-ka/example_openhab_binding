name := "examplebinding"
organization := "org.openhab.binding"

version := "0.1"

scalaVersion := "2.13.0"

val openhabVersion = "2.4.0"

resolvers += "Openhab Bintray" at "https://dl.bintray.com/openhab/mvn"
resolvers += "Openhab Artifactory" at "https://openhab.jfrog.io/openhab/libs-release"
resolvers += "Eclipse Smarthome" at "http://eclipse.github.io/smarthome/third-party/m2-repo/"

val deps = Seq(
  "org.openhab.distro" % "openhab-addons" % openhabVersion % "provided",
  "org.osgi" % "org.osgi.service.component" % "1.4.0" % "provided",
  "org.osgi" % "org.osgi.service.component.annotations" % "1.4.0" % "provided",
  "org.eclipse.jdt" % "org.eclipse.jdt.annotation" % "2.1.150" % "provided"
)

libraryDependencies ++= deps.map(_ exclude("org.eclipse.smarthome.test", "*"))

enablePlugins(SbtOsgi)

osgiSettings

OsgiKeys.exportPackage := Seq("org.openhab.binding.examplebinding")
