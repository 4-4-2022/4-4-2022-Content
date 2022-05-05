package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.soap.service.OrderService;

@RestController("messageController")
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/soap-message")
	public Object getSoapMessage() {
		return this.orderService.findAll();
	}

}
