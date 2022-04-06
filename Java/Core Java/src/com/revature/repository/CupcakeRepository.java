package com.revature.repository;

import com.revature.model.Cupcake;

public interface CupcakeRepository {
	
	public Cupcake[] findAllCupcakes();
	public Cupcake findCupcakeByFlavor(String flavor);
	
}
