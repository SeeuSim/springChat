package com.chatGroup.chatApp

import org.slf4j.LoggerFactory
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

@Component
class Receiver {

    @JmsListener(
        destination = "mailbox",
        containerFactory = "myFactory"
    )
    fun receiveMessage(message: Message) {
        val logger = LoggerFactory.getLogger(Receiver::class.java)
        logger.info("==> Received: {$message}")
    }
}