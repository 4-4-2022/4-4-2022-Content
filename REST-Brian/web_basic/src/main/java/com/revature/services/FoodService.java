package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Bread;
import com.revature.models.Food;
import com.revature.repository.DummyData;

@Service
public class FoodService {
	
	private DummyData dummyData;
	
	@Autowired
	public FoodService(DummyData dummyData) {
		this.dummyData = dummyData;
	}

	public Food getFood(long id) {
		List<Bread> breads = dummyData.bread;
		
		for(Bread bread : breads) {
			if(bread.getId() == id) {
				return convertToFood(bread);
			}
		}
		return null;
	}

	private Food convertToFood(Bread bread) {
		return new Food(
				bread.getId(), 
				bread.getName(), 
				"This is a" + 
				bread.getColor() + 
				" bread, it weighs " + 
				bread.getWeight() + "g");
	}

}
