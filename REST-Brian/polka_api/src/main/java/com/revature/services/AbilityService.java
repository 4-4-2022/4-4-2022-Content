package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Ability;
import com.revature.models.DisplayAbility;
import com.revature.respositories.DummyData;

@Service
public class AbilityService {
	
	private DummyData dummyData;
	
	@Autowired
	public AbilityService(DummyData dummyData) {
		this.dummyData = dummyData;
	}

	public Ability getAbility(long id) {
		List<Ability> abilities = dummyData.abilities;
		for(Ability ability : abilities) {
			if(ability.getId() == id) {
				return ability;
			}
		}
		return null;
	}

	public List<DisplayAbility> getAbilities(List<Integer> abilities) {
		List<DisplayAbility> displayAbility = new ArrayList<>();
		for(Integer id: abilities) {
			Ability ability = getAbility(id);
			displayAbility.add(new DisplayAbility(ability.getId(), ability.getLabel(), "http://localhost:8080/polka/ability/" + id));
		}
		
		return displayAbility;
	}

}
