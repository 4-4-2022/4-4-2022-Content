package com.revature.model;

/*
 * We will use this class as a base class for our shop's desserts. The idea is that cupcakes (as well as ice cream and cupcakes
 * and chocolate strawberries, etc.) all have some properties in common at the very least. For instance, all foods have nutrition
 * information. That said, we can use this base class to pass on those properties to our more specific desserts.
 * 
 * We've now turned Dessert into an abstract classes. Abstract classes are allowed to have abstract methods. The point of an abstract
 * class is to be inherited from.
 */
public abstract class Dessert {

	// Providing base properties of desserts
	private int calories;
	private boolean isGlutenFree;
	private boolean isVegan;

	public Dessert() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dessert(int calories, boolean isGlutenFree, boolean isVegan) {
		super();
		this.calories = calories;
		this.isGlutenFree = isGlutenFree;
		this.isVegan = isVegan;
	}
	
	/*
	 * This is an abstract method. This means that this method has no implementation. We intend to give this method an implementation
	 * in our child classes. The idea is that child classes will need to provide unique implementations of this method.
	 */
	public abstract void cook();

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public boolean isGlutenFree() {
		return isGlutenFree;
	}

	public void setGlutenFree(boolean isGlutenFree) {
		this.isGlutenFree = isGlutenFree;
	}

	public boolean isVegan() {
		return isVegan;
	}

	public void setVegan(boolean isVegan) {
		this.isVegan = isVegan;
	}

	@Override
	public String toString() {
		return "Dessert [calories=" + calories + ", isGlutenFree=" + isGlutenFree + ", isVegan=" + isVegan + "]";
	}
}
