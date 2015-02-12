package com.jonfk

import akka.actor.ActorSystem
import org.pircbotx.{PircBotX, Configuration}

object Boot {
  def main(args : Array[String]): Unit = {

    val system = ActorSystem("IRCBotActorSystem")

    val botActor = system.actorOf(BotActor.props, "botActor")

    val botConfig : Configuration[PircBotX] = new Configuration.Builder()
      .setName("bot_acter_test")
      .setServerHostname("irc.freenode.net")
      .addAutoJoinChannel("#bottest")
      .addListener(new BotListener)
      .buildConfiguration()

    botActor ! BotActor.Initialize(botConfig)

    //  val pingActor = system.actorOf(PingActor.props, "pingActor")
    //  pingActor ! PingActor.Initialize

    // This example app will ping pong 3 times and thereafter terminate the ActorSystem -
    // see counter logic in PingActor
    //  system.awaitTermination()
  }
}