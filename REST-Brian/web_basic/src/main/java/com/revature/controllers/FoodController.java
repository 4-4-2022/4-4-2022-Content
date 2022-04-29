package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Food;
import com.revature.services.FoodService;

// Add this annotation to provide some REST basic necessities
// For providing a REST API
@RestController
@RequestMapping("/foods")
public class FoodController {
	
	@Autowired
	private FoodService foodService;

	// Add this annotation above a method to provide
	// a GET mapping
	// This one links the URL of "http://localhost:8080/foods"
	// to this method
	@GetMapping("/test")
	public String getFood() {
		Food food = new Food(1, "Cupcake", "Tasty!");
		return food.getName();
	}
	
	// This get mapping is looking for a path variable
	// It uses the syntax {name} and to reference in the parameter
	// We use @PathVariable and the name plus type of the parameter
	@GetMapping("/bread/{id}")
	public Food getBread(@PathVariable long id) {
		Food bread = foodService.getFood(id);
		return bread;
	}
}
