package com.revature.model;

/*
 * The idea behind the Factory design pattern is that the caller might request an object, but we might not know exactly what the
 * type of that object is. Using a factory, we can take advantage of inheritance to return any subtype of dessert upon request.
 */
public class DessertFactory {

	public static Dessert getDessert(String dessertType) {
		
		switch(dessertType) {
		case "cupcake":
			return new Cupcake();
		case "cookie":
			return new Cookie();
		default:
			return null;
		}
	}
}
