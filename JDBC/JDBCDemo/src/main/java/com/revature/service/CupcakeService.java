package com.revature.service;

import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.model.Cupcake;
import com.revature.repository.CupcakeRepository;
import com.revature.repository.CupcakeRepositoryImpl;

public class CupcakeService {

	/*
	 * We have introduced Logback into our project in order to log events that occur in our application. We will log these events
	 * to a file that we can refer to later to track the events that are occurring in our application. These events can include exceptions
	 * that have been thrown, information about what types of data users have requested, and user transactions.
	 * 
	 * Because we used Maven to download the jar file for Logback and add it to our classpath, we already have access to Logback-specific
	 * classes.
	 */
	private static final Logger logger = LoggerFactory.getLogger(CupcakeService.class);
	
	private CupcakeRepository cupcakeRepository;
	
	public CupcakeService() {
		this.cupcakeRepository = CupcakeRepositoryImpl.getCupcakeRepository();
	}
	
	public String[] takeCupcakeInfo(Scanner scanner) {
		String userFlavor = scanner.nextLine();
		String[] flavors = userFlavor.split(",");
		return flavors;
	}
	/**
	 * If you are using variable arguments, the var-arg MUST be the last parameter. This implies that there can only be one var-arg.
	 * @param flavors
	 * @return a Set of type Cupcake
	 */
	public Set<Cupcake> findCupcakesByFlavor(String...flavors){
		Set<Cupcake> retrievedCupcakes = null;
		retrievedCupcakes = this.cupcakeRepository.findCupcakesByFlavor(flavors);
		//Let's log the retrieved cupcakes.
		logger.info("The retrieved cupcakes are: " + retrievedCupcakes);
		return retrievedCupcakes;
	}
	
	public Set<Cupcake> findAllCupcakes(){
		return this.cupcakeRepository.findAllCupcakes();
	}
	
	public void save(Cupcake cupcake) {
		this.cupcakeRepository.save(cupcake);
	}
}
