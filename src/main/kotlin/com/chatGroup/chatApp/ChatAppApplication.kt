package com.chatGroup.chatApp

import jakarta.jms.ConnectionFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.jms.annotation.EnableJms
import org.springframework.jms.config.DefaultJmsListenerContainerFactory
import org.springframework.jms.config.JmsListenerContainerFactory
import org.springframework.jms.core.JmsTemplate
import org.springframework.jms.support.converter.MappingJackson2MessageConverter
import org.springframework.jms.support.converter.MessageConverter
import org.springframework.jms.support.converter.MessageType

@SpringBootApplication
@EnableJms
class ChatAppApplication {

	@Bean
	fun myFactory(
		connectionFactory: ConnectionFactory,
		configureFactory: DefaultJmsListenerContainerFactoryConfigurer
	): JmsListenerContainerFactory<*> {
		val factory = DefaultJmsListenerContainerFactory()
		// This provides all autoconfigured defaults to this factory, including the message converter
		configureFactory.configure(factory, connectionFactory)
		// You could still override some settings if necessary.
		return factory
	}

	@Bean // Serialize message content to json using TextMessage
	fun jacksonJmsMessageConverter(): MessageConverter {
		val converter = MappingJackson2MessageConverter()
		converter.setTargetType(MessageType.TEXT)
		converter.setTypeIdPropertyName("_type")
		return converter
	}
}

fun main(args: Array<String>) {
	val context = runApplication<ChatAppApplication>(*args)

	val jmsTemplate = context.getBean(JmsTemplate::class.java)

	// Send a message with a POJO - the template reuse the message converter

	// Send a message with a POJO - the template reuse the message converter
	println("Sending an email message.")
	jmsTemplate.convertAndSend("mailbox", Message("@zuckerberg", "Hello"))
}
