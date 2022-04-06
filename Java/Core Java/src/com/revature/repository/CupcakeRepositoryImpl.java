package com.revature.repository;

import java.util.HashSet;
import java.util.Set;

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
	 * 
	 * Collection
	 * List
	 */

	/*Our first order of business is creating the array. This is our mock data. It is currently "empty" but has space for 10 cupcakes.
	 * 
	 * NOTE: This was originally just an array, but we realized that the array wasn't meeting our needs. It was fixed in size, and we
	 * needed something that could accommodate for an unknown number of cupcakes at any given time. We've changed it into
	 * an ArrayList (an implementation of the List interface).
	 * 
	 * Please note that it is not good practice to not use generics with collections. Generics simply add some compile-time safety
	 * by ensuring that only objects of a certain type can be added to a collection.
	 * 
	 * NOTE: We have once again changed the group of cupcakes. It is now set. Sets are different lists in that: Queue
	 * 
	 * 1) Lists allow duplicates while sets do not allow for duplicates.
	 * 2) Lists will preserve the order of the elements while sets do not guarantee the order.
	 * 3) Lists support random access while sets do not.
	 */
	
	private Set<Cupcake> cupcakes = new HashSet<>();
	
	// We're using this constructor to initialize some of the mock cupcakes.
	public CupcakeRepositoryImpl() {
		super();
		this.cupcakes.add(new Cupcake("Champagne Cake", (short) 3, "Sugar Bee Sweets", 100, true, true));
		this.cupcakes.add(new Cupcake("Chocolate Cake", (short) 2, "Sugar Bee Sweets", 400, false, false));
		this.cupcakes.add(new Cupcake("Strawberry Cake", (short) 2, "Sugar Bee Sweets", 300, true, false));
		this.cupcakes.add(new Cupcake("Carrot Cake", (short) 2, "Sugar Bee Sweets", 250, false, true));
	}
	
	/*
	 * Now that we have our constructor, let's think about methods that simulate data access. For instance, we know that we need to
	 * read from our array of cupcakes as there would be no way to list all of these cupcakes from our repository if we didn't at least
	 * allow for this. That said, let's make a method that returns the array of cupcakes to the caller.
	 */
	
	public Set<Cupcake> findAllCupcakes() {
		return this.cupcakes;
	}

	@Override
	public Cupcake findCupcakeByFlavor(String flavor) {
		// TODO Auto-generated method stub
		return null;
	}
}
