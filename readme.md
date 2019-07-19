# Scala Openhab bundle

This projected is intended as a simple skeleton for Openhab bindings written in scala.

As a build system sbt is used with the sbt-osgi plugin.

The scala bundle needed to actually use the generated bundle was acquired using the openmole project.

# Usage
1. `sbt osgiBundle`
2. start docker daemon
3. `bash startup.sh`
