package com.revature.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.models.Bread;

@RestController
public class BreadController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/bread")
	public Bread getBread(@PathParam(value = "id") long id) {
		ResponseEntity<Bread> bread = restTemplate.getForEntity("http://localhost:8080/foods/bread/" + id, Bread.class);
		return bread.getBody();
	}
	
}
