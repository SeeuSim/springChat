package com.chatGroup.chatApp

import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

@Component
class Receiver {

    @JmsListener(
        destination = "mailbox",
        containerFactory = "myFactory"
    )
    fun receiveMessage(message: Message) {
        println("Received: {" + message + "}")
    }
}