package com.jonfk

import akka.actor.{Actor, ActorLogging, Props}
import org.pircbotx.{PircBotX, Configuration}
import org.pircbotx.hooks.ListenerAdapter
import org.pircbotx.hooks.types.GenericMessageEvent

class BotActor extends Actor with ActorLogging {
  import BotActor._

  def receive = {
    case Initialize(config: Configuration[PircBotX]) =>
      log.info("In BotActor - Starting Bot Actor")
      val bot = new PircBotX(config)
      bot.startBot()
  }
}

object BotActor {
  val props = Props[BotActor]
  case class Initialize(config : Configuration[PircBotX])
}

class BotListener extends ListenerAdapter[PircBotX] {
  override def onGenericMessage(event : GenericMessageEvent[PircBotX]) {

    //When someone says ?helloworld respond with "Hello World"
    if (event.getMessage.startsWith("?helloworld")) {
      event.respond("Hello world!")
    }

  }
}
