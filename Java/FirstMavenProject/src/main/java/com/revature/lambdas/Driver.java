package com.revature.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import com.revature.model.Cupcake;

public class Driver {

	public static void main(String[] args) {
		/*
		 * The type of a lambda expression must be a functional interface.
		 */
		Math addition = (int num1, int num2) -> {
			int sum = num1 + num2;
			return sum;
			};
		Math subtraction = (num1, num2) -> num1 - num2;
		
		/*
		 * There are several built-in functional interfaces in Java. For instance:
		 * 
		 * Predicate
		 * BiPredicate
		 * Function
		 * BiFunction
		 * Comparator
		 * Consumer
		 * Supplier
		 */
		
		List<Cupcake> cupcakes = new ArrayList<>();
		cupcakes.add(new Cupcake("Champagne Cake", (short) 3, "Sugar Bee Sweets", 100, true, true));
		cupcakes.add(new Cupcake("Chocolate Cake", (short) 20, "Sugar Bee Sweets", 400, false, false));
		cupcakes.add(new Cupcake("Strawberry Cake", (short) 1, "Sugar Bee Sweets", 300, true, false));
		cupcakes.add(new Cupcake("Carrot Cake", (short) 200, "Sugar Bee Sweets", 250, false, true));
		
		Collections.sort(cupcakes);
		System.out.println(cupcakes);
		
		/*
		 * These are some practical uses of lambda expressions. The first example here passes a Comparator to an overload of the sort
		 * method in order to specify a new way of ordering cupcakes on the fly. The second uses a Predicate to remove cupcakes that
		 * have more than 300 calories in them.
		 */
		Collections.sort(cupcakes, (cupcake1, cupcake2) -> cupcake1.getCalories() - cupcake2.getCalories());
		System.out.println(cupcakes);
		
		cupcakes.removeIf((cupcake) -> cupcake.getCalories() > 300);
		System.out.println(cupcakes);
		
		/*
		 * Streams provide that additional utility for easily filtering, transforming, and reducing collections.
		 */
		Stream<Cupcake> cupcakeStream = cupcakes.stream();
		cupcakeStream.forEach((cupcake) -> cupcake.setCalories(cupcake.getCalories() + 100));
	}
}
