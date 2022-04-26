package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * If we're no longer explicitly writing our SQL queries using JDBC, Spring needs a way to be able
 * to match our models up to our DB tables. That said, we must use JPA to map our models to our
 * tables. Fortunately, JPA is annotation-driven.
 */

/*
 * This annotation marks this class as an entity that can be managed by JPA. This means that there
 * should be a corresponding table for this model in the database.
 */
@Entity

/*
 * This annotation allows us to map this particular class to a table in the database. We can
 * specify the name, but it is optional as the class name will just be used as the table name
 * by default.
 */
@Table(name = "cupcake")
public class Cupcake extends Dessert implements Edible, Comparable<Cupcake>{
	
	/*
	 * The @Id annotation specifies that this column is the primary key.
	 */
	@Id
	@Column(name = "cupcake_flavor", unique = true, nullable = false)
	private String cupcakeFlavor;
	@Column(name = "cupcake_cost", nullable = false)
	private float cost;
	
	public Cupcake() {
		super();
	}
	
	public Cupcake(String cupcakeFlavor, float cost, int bakery_id, int calories, boolean isGlutenFree, boolean isVegan) {
		super(calories, isGlutenFree, isVegan);
		this.cupcakeFlavor = cupcakeFlavor;
		this.cost = cost;
	}
	
	public String getCupcakeFlavor() {
		return cupcakeFlavor;
	}

	public void setCupcakeFlavor(String cupcakeFlavor) {
		this.cupcakeFlavor = cupcakeFlavor;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	

	@Override
	public String toString() {
		return "Cupcake [cupcakeFlavor=" + cupcakeFlavor + ", cost=" + cost + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(cost);
		result = prime * result + ((cupcakeFlavor == null) ? 0 : cupcakeFlavor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cupcake other = (Cupcake) obj;
		if (Float.floatToIntBits(cost) != Float.floatToIntBits(other.cost))
			return false;
		if (cupcakeFlavor == null) {
			if (other.cupcakeFlavor != null)
				return false;
		} else if (!cupcakeFlavor.equals(other.cupcakeFlavor))
			return false;
		return true;
	}

	@Override
	public void cook() {
		System.out.println("Something specific to cooking cupcakes.");
		
	}

	@Override
	public void provideNutrients() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * We must implement this method in a such a way that it reflects what we think makes one cupcake "greater" or "less" than another
	 * cupcake.
	 */
	@Override
	public int compareTo(Cupcake o) {
		return this.cupcakeFlavor.compareTo(o.cupcakeFlavor);
	}
	
}
