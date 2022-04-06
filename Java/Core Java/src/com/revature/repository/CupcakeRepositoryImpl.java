package com.revature.repository;

import com.revature.model.Cupcake;

/*
 * This Cupcake repository is my source of data concerning "records" of the cupcakes we have
 * in stock. I don't have a connection to a DB right now, so I'll have to have some sort hardcoded
 * array for the time being.
 */
public class CupcakeRepositoryImpl implements CupcakeRepository{

	/*
	 * In order to create an instance (an object) of our Cupcake class, we've used
	 * the "new" keyword with the class's constructor.
	 * 
	 * Note that we've now stored all of our cupcakes in an array. This gives us the
	 * benefit of being able to use this single reference to access all of the
	 * cupcakes. That said, arrays do come with a con: their length can't be
	 * changed. That is to say, their size is fixed.
	 */

	//Our first order of business is creating the array. This is our mock data. It is currently "empty" but has space for 10 cupcakes.
	private Cupcake[] cupcakes = new Cupcake[10];
	
	// We're using this constructor to initialize some of the mock cupcakes.
	public CupcakeRepositoryImpl() {
		super();
		this.cupcakes[0] = new Cupcake("Champagne Cake", (short) 3, "Sugar Bee Sweets", 100, true, true);
		this.cupcakes[1] = new Cupcake("Chocolate Cake", (short) 2, "Sugar Bee Sweets", 400, false, false);
		this.cupcakes[2] = new Cupcake("Strawberry Cake", (short) 2, "Sugar Bee Sweets", 300, true, false);
		this.cupcakes[3] = new Cupcake("Carrot Cake", (short) 2, "Sugar Bee Sweets", 250, false, true);
	}
	
	/*
	 * Now that we have our constructor, let's think about methods that simulate data access. For instance, we know that we need to
	 * read from our array of cupcakes as there would be no way to list all of these cupcakes from our repository if we didn't at least
	 * allow for this. That said, let's make a method that returns the array of cupcakes to the caller.
	 */
	
	public Cupcake[] findAllCupcakes() {
		return this.cupcakes;
	}

	@Override
	public Cupcake findCupcakeByFlavor(String flavor) {
		// TODO Auto-generated method stub
		return null;
	}
}
