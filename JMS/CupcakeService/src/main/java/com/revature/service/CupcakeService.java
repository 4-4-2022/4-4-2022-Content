package com.revature.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Cupcake;
import com.revature.repository.CupcakeRepository;

@Service("cupcakeService")
public class CupcakeService {

	private CupcakeRepository cupcakeRepository;
	
	@Autowired
	public void setCupcakeRepository(CupcakeRepository cupcakeRepository) {
		this.cupcakeRepository = cupcakeRepository;
	}
	
	public List<Cupcake> findAll() {
		return this.cupcakeRepository.findAll();
	}

	public void save(Cupcake cupcake) {
		this.cupcakeRepository.save(cupcake);
	}
	
	public Cupcake findByCupcakeFlavor(String flavor) {
		return this.cupcakeRepository.findByCupcakeFlavor(flavor);
	}
	
	public List<Cupcake> findAllByCostBetween(float cost1, float cost2){
		return this.cupcakeRepository.findAllByCostBetween(cost1, cost2);
	}

}
