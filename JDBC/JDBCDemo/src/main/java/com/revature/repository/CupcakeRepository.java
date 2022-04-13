package com.revature.repository;

import java.util.Set;

import com.revature.model.Cupcake;

public interface CupcakeRepository {
	
	public Set<Cupcake> findAllCupcakes();
	public Cupcake findCupcakeByFlavor(String flavor);
	public Set<Cupcake> findCupcakesByFlavor(String...flavors);
	public void save(Cupcake cake);
	public void update(Cupcake cupcake);
	public void delete(Cupcake cupcake);
	
}
