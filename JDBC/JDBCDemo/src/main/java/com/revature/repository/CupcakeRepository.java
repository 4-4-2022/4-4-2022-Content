package com.revature.repository;

import java.util.Set;

import com.revature.model.Cupcake;

public interface CupcakeRepository {
	
	public Set<Cupcake> findAllCupcakes();
	public Cupcake findCupcakeByFlavor(String flavor);
	public Set<Cupcake> findCupcakesByFlavor(String...flavors);
	
}
