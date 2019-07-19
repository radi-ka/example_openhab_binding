package org.openhab.binding.examplebinding

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import org.eclipse.smarthome.core.library.types.StringType
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler
import org.eclipse.smarthome.core.thing.{ChannelUID, Thing, ThingStatus}
import org.eclipse.smarthome.core.types.Command

class ExampleThingHandler(thing: Thing, channel: String) extends BaseThingHandler(thing) {

  val config: ExampleConfig = thing.getConfiguration.as(classOf[ExampleConfig])

  override def handleCommand(channelUID: ChannelUID, command: Command): Unit = {
    publishMessage()
  }

  def publishMessage(): Unit = {
    if (thing.getStatus ne ThingStatus.ONLINE) {
      updateStatus(ThingStatus.ONLINE)
    }

    val state = new StringType(s"hello ${thing.getLabel}:${config.name}! @" + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))

    updateState(channel, state)
  }

  updateStatus(ThingStatus.ONLINE)
}
