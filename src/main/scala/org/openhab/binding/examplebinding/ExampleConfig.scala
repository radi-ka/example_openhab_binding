package org.openhab.binding.examplebinding

case class ExampleConfig(var name: String) {
  def this() {
    this("")
  }
}