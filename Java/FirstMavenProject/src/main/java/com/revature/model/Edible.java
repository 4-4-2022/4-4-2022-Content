package com.revature.model;

/*
 * Many interfaces in Java are named like adjectives (e.g. Serializable, Cloneable, Comparable).
 * 
 * Interfaces, like abstract classes, are abstract. Interfaces are, in fact, assumed to be abstract, so you don't have to use the "abstract"
 * modifier.
 */

public interface Edible {

	/*
	 * All methods on an interface are assumed to be assumed to be "abstract", which means that this modifier is implicitly added. They
	 * are also assumed to be "public".
	 */
	void provideNutrients();
	
	/*
	 * It is possible to have methods with implementations on an interface. You have to either:
	 * 
	 * 1) Use the "static" keyword in the method signature
	 * 2) Use the "default' keyword in the method signature
	 * 
	 * The idea behind having a default implementation is that perhaps many implementing classes could make good use of the
	 * default implementation but perhaps a select few implementing classes would need to override the method.
	 */
	
	public static void tastePalatable() {
		
	}
}
