package org.openhab.binding.examplebinding

import org.eclipse.jdt.annotation.{NonNullByDefault, Nullable}
import org.eclipse.smarthome.core.thing.binding.{BaseThingHandlerFactory, ThingHandler, ThingHandlerFactory}
import org.eclipse.smarthome.core.thing.{Thing, ThingTypeUID}
import org.osgi.service.component.annotations.Component

@NonNullByDefault
@Component(configurationPid = Array("binding.examplebinding"), service = Array(classOf[ThingHandlerFactory]), immediate = true)
class ExampleThingHandlerFactory extends BaseThingHandlerFactory {
  override def supportsThingType(thingTypeUID: ThingTypeUID): Boolean = ExampleThingHandlerFactory.SUPPORTED_THING_TYPES_UIDS.contains(thingTypeUID.getId)

  @Nullable override protected def createHandler(thing: Thing): ThingHandler = {
    new ExampleThingHandler(thing, ExampleBindingConstants.EXAMPLE_CHANNEL)
  }
}

object ExampleThingHandlerFactory {
  private val SUPPORTED_THING_TYPES_UIDS = Seq(ExampleBindingConstants.THING_TYPE_EXAMPLE_TEXT)
}