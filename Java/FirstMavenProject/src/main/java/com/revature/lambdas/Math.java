package com.revature.lambdas;

/*
 * This interface is a functional interface because it has one and only one abstract method.
 * 
 * Note that the @FunctionalInterface annotation, while optional, provides some compile-time safety in that if someone were to
 * accidentally add another abstract method to this interface, the interface wouldn't compile.
 */
@FunctionalInterface
public interface Math {

	int doMath(int num1, int num2);
	
	/*
	 * Yes, a functional interface can have other methods, but only one can be abstract.
	 */
	public static void otherMethod() {
		
	}
}
