package com.revature.service;

import java.util.Scanner;
import java.util.Set;

import com.revature.model.Cupcake;
import com.revature.repository.CupcakeRepository;
import com.revature.repository.CupcakeRepositoryImpl;

public class CupcakeService {

	private CupcakeRepository cupcakeRepository;
	
	public CupcakeService() {
		this.cupcakeRepository = new CupcakeRepositoryImpl();
	}
	//Error
	/**
	 * If you are using variable arguments, the var-arg MUST be the last parameter. This implies that there can only be one var-arg.
	 * @param scanner
	 * @param flavors
	 * @return
	 */
	public Set<Cupcake> findCupcakesByFlavor(Scanner scanner){
		Set<Cupcake> retrievedCupcakes = null;
		String userFlavor = scanner.nextLine();
		String[] flavors = userFlavor.split(",");
		retrievedCupcakes = this.cupcakeRepository.findCupcakesByFlavor(flavors);
		return retrievedCupcakes;
	}
}
