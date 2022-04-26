package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Cupcake;

/*
 * When using Spring Data JPA, you are not responsible for implementing methods that connect to the
 * DB and return records. Basically, we're eliminating the need to write such boilerplate code. 
 * Spring Data JPA actually provides pre-implemented methods that perform most of the basic CRUD will
 * need in a enterprise application.
 * 
 * In order to take advantage of those implementations, you simply need to extend the JpaRepository
 * interface.
 */
@Repository("cupcakeRepository")
public interface CupcakeRepository extends JpaRepository<Cupcake, Integer>{
	
	public List<Cupcake> findAll();
	public Cupcake findByCupcakeFlavor(String flavor);
	public List<Cupcake> findByCostGreaterThan(float cost);
	public <S extends Cupcake> S save(Cupcake cake);
	public void delete(Cupcake cupcake);
	
}
