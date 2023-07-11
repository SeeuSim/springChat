package com.chatGroup.chatApp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ChatAppApplication

fun main(args: Array<String>) {
	runApplication<ChatAppApplication>(*args)
}
