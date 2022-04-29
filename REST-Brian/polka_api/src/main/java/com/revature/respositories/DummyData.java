package com.revature.respositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.entities.Ability;
import com.revature.entities.Polkamon;

@Component
public class DummyData {
	
	public List<Polkamon> polkamons;
	public List<Ability> abilities;
	
	public DummyData() {
		polkamons = new ArrayList<>();
		abilities = new ArrayList<>();
		
		abilities.add(new Ability(1, "Punch", "Polkamon punches really hard!"));
		abilities.add(new Ability(2, "Retreat", "Polkamon runs away!"));
		
		polkamons.add(new Polkamon(1, "Greg", Arrays.asList(1)));
		polkamons.add(new Polkamon(2, "Leanne", Arrays.asList(1, 2)));
	}
}
