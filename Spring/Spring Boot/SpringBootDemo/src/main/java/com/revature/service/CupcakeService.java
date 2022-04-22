package com.revature.service;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Cupcake;
import com.revature.repository.CupcakeRepository;

/*
 * The @Service stereotype is designed to be used with types that are devoted to business logic.
 */
@Service("cupcakeService")
public class CupcakeService {
	
	private CupcakeRepository cupcakeRepository;
	
	
	public CupcakeService() {}
	
	public CupcakeService(CupcakeRepository cupcakeRepository) {
		this.cupcakeRepository = cupcakeRepository;
	}
	
	/*
	 * By default, Spring will use a type's setter to attempt to inject a dependency. This is called setter injection.
	 * And, yes, the setter does need to have a name that is "conventional". In other words, the setter should follow
	 * the pattern "set + property name".
	 * 
	 * The @Autowired annotation instructs Spring to autowire in the cupcakeRepository dependency using the setter.
	 * Note that you can also choose to annotate the constructor or even the field itself to autowire the dependency
	 * in. The field injection, however, is considered bad practice as it's not easily testable.
	 */
	@Autowired
	public void setCupcakeRepository(CupcakeRepository cupcakeRepository) {
		this.cupcakeRepository = cupcakeRepository;
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
	public Cupcake findByFlavor(String flavor){
		Cupcake retrievedCupcake = null;
		retrievedCupcake = this.cupcakeRepository.findByCupcakeFlavor(flavor);
		//Let's log the retrieved cupcakes.
		return retrievedCupcake;
	}
	
	public List<Cupcake> findAllCupcakes(){
		return this.cupcakeRepository.findAll();
	}
	
	public void save(Cupcake cupcake) {
		this.cupcakeRepository.save(cupcake);
	}
}
