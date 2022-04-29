package com.revature.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.models.PolkaDTO;
import com.revature.models.Polkamon;

@RestController
public class PolkaController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/polka")
	public Polkamon getPolka(@PathParam(value="id") long id) {
		ResponseEntity<Polkamon> polkamon = restTemplate.getForEntity("http://localhost:8080/polka/" + id, Polkamon.class); 
		return polkamon.getBody();
	}
	
	@PostMapping("/polka/new")
	public String createPolka(@RequestBody PolkaDTO polkamon) {
		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/polka/new", polkamon, String.class);
		return response.getBody();
	}
}
