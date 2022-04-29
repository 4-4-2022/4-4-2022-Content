package com.revature.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/*
 * Because our JPA provider doesn't automatically map fields that are inherited from a super type,
 * we do have to explicitly specify that our super class has fields that should be translated
 * as columns when we map child classes.
 */
@MappedSuperclass
public abstract class Dessert {
	
	@Column
	private int calories;
	@Column
	private boolean isGlutenFree;
	@Column
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
