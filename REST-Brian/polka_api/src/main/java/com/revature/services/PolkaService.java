package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Polkamon;
import com.revature.models.DisplayAbility;
import com.revature.models.DisplayPolkamon;
import com.revature.respositories.DummyData;

@Service
public class PolkaService {
	
	private DummyData dummyData;
	private AbilityService abilityService;
	
	@Autowired
	public PolkaService(DummyData dummyData, AbilityService abilityService) {
		this.dummyData = dummyData;
		this.abilityService = abilityService;
	}

	public DisplayPolkamon getPolka(long id) {
		List<Polkamon> polkamons = dummyData.polkamons;
		for(Polkamon polka : polkamons) {
			if (polka.getId() == id) {
				return convertToDisplay(polka);
			}
		}
		
		return null;
	}

	private DisplayPolkamon convertToDisplay(Polkamon polka) {
		List<DisplayAbility> displayAbility = abilityService.getAbilities(polka.getAbilities());
		
		return new DisplayPolkamon(
				polka.getId(),
				polka.getName(),
				displayAbility);
	}

	public Polkamon createPolkamon(Polkamon polkamon) {
		dummyData.polkamons.add(
				new Polkamon(
						dummyData.polkamons.size() + 1, 
						polkamon.getName(), 
						polkamon.getAbilities()));
		return polkamon;
	}
	
	

}
