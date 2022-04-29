package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.entities.Bread;

@Component
public class DummyData {
	
	public List<Bread> bread;
	
	public DummyData() {
		bread = new ArrayList<>();
		bread.add(new Bread(1, "Baguette", "Orange", 500));
		bread.add(new Bread(2, "Focaccia", "Yellow", 300));
		bread.add(new Bread(3, "Hoggie", "Brown", 400));
	}

}
