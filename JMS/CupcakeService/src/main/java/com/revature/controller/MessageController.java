package com.revature.controller;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.CupcakePurchaseDto;

@RestController("messageController")
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private Destination simpleMessageQueue;
	
	@GetMapping("/simple")
	public Object getSimpleMessage() {
		return this.jmsTemplate.receiveAndConvert(this.simpleMessageQueue);
	}
	
	/*
	 * If you're using a listener, the idea is not that you want a message to be available immediately
	 * to be returned to a client. 
	 * 
	 * This JmsListener performs nonblocking requests to the broker for new messages.
	 */
	@JmsListener(destination = "simpleMessageTopic", containerFactory = "jmsListenerContainerFactory" )
	public void listenForMessage(@Payload CupcakePurchaseDto message) {
		System.out.println(message);
	}
}
