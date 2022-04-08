package com.revature.repository;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.revature.model.Cupcake;

/*
 * This Cupcake repository is my source of data concerning "records" of the cupcakes we have
 * in stock. I don't have a connection to a DB right now, so I'll have to have some sort hardcoded
 * array for the time being.
 * 
 * This class has also been modified so that it is a Singleton.
 */
public class CupcakeRepositoryImpl implements CupcakeRepository{
	
	private static CupcakeRepositoryImpl cupcakeRepository;
	public static int counter;

	/*
	 * In order to create an instance (an object) of our Cupcake class, we've used
	 * the "new" keyword with the class's constructor.
	 * 
	 * Note that we've now stored all of our cupcakes in an array. This gives us the
	 * benefit of being able to use this single reference to access all of the
	 * cupcakes. That said, arrays do come with a con: their length can't be
	 * changed. That is to say, their size is fixed.
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
	
	private Set<Cupcake> cupcakes = new TreeSet<>();
	
	/*We're using this constructor to initialize some of the mock cupcakes. For the sake of turning this class into a Singleton, we have
	 * made the constructor private so that instances cannot be freely created throughout the application.
	 */
	
	private CupcakeRepositoryImpl() {
		super();
		this.cupcakes.add(new Cupcake("Champagne Cake", (short) 3, "Sugar Bee Sweets", 100, true, true));
		this.cupcakes.add(new Cupcake("Chocolate Cake", (short) 20, "Sugar Bee Sweets", 400, false, false));
		this.cupcakes.add(new Cupcake("Strawberry Cake", (short) 1, "Sugar Bee Sweets", 300, true, false));
		this.cupcakes.add(new Cupcake("Carrot Cake", (short) 200, "Sugar Bee Sweets", 250, false, true));
		counter++;
	}
	
	/*
	 * When building a Singleton, it is typical to see a method that returns the single instance of this type to the caller. We create the
	 * single instance within the context of this class and return that same instance to the caller every single time this method is called.
	 * 
	 * We've added the synchronized keyword here in order to prevent multiple instances of this type from being from created in a
	 * multi-threaded environment (as in our demo earlier). Yes, synchronization makes the program slower, but it prevents us from
	 * our breaking our design pattern.
	 */
	public static synchronized CupcakeRepositoryImpl getCupcakeRepository() {
		if(cupcakeRepository == null) {
			cupcakeRepository = new CupcakeRepositoryImpl();
		}
		return cupcakeRepository;
	}
	
	/*
	 * Now that we have our constructor, let's think about methods that simulate data access. For instance, we know that we need to
	 * read from our array of cupcakes as there would be no way to list all of these cupcakes from our repository if we didn't at least
	 * allow for this. That said, let's make a method that returns the array of cupcakes to the caller.
	 */
	
	public Set<Cupcake> findAllCupcakes() {
		return this.cupcakes;
	}

	/**
	 * This method iterates over our repository of cupcakes and finds the cupcake of a specific flavor.
	 * 
	 * @param flavor the flavor of the cupcake that should be returned
	 */
	@Override
	public Cupcake findCupcakeByFlavor(String flavor) {
		
		for(Cupcake cupcake : cupcakes) {
			if(cupcake.getCupcakeFlavor().equalsIgnoreCase(flavor)) {
				return cupcake;
			}
		}
		return null;
	}
	
	@Override
	public Set<Cupcake> findCupcakesByFlavor(String...flavors) {
		Set<Cupcake> requestedCupcakes = new HashSet<>();
		
		for(Cupcake cupcake : cupcakes) {
			for(String flavor : flavors) {
				if(cupcake.getCupcakeFlavor().equalsIgnoreCase(flavor)) {
					requestedCupcakes.add(cupcake);
				}
			}
		}
		return requestedCupcakes;
	}
}
