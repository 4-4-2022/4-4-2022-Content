package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Ability;
import com.revature.entities.Polkamon;
import com.revature.models.DisplayPolkamon;
import com.revature.services.AbilityService;
import com.revature.services.PolkaService;

@RestController
@RequestMapping("/polka")
public class PolkaController {

	@Autowired
	private PolkaService polkaService;
	
	@Autowired
	private AbilityService abilityService;
	
	@GetMapping("/{id}")
	public DisplayPolkamon getPolka(@PathVariable long id) {
		return polkaService.getPolka(id);
	}
	
	@GetMapping("/ability/{id}")
	public Ability getAbility(@PathVariable long id) {
		return abilityService.getAbility(id);
	}
	
	@CrossOrigin(origins = "http://localhost:6060")
	@PostMapping("/new")
	public String createPolkamon(@RequestBody Polkamon polkamon) {
		Polkamon newPolkamon = polkaService.createPolkamon(polkamon);
		return newPolkamon.getName() + " was created!";
	}
	
}
