package com.revature.client;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.model.Cupcake;

public class AppUI {

	/*
	 * I've made this method static because I do not want to create an instance of this class just to call this simple print method.
	 */
	public static void printWelcomeMenu() {
		System.out.println(
				"Welcome, user! What would you like to do?\n"
				+ "1) View Cupcakes \n2) About Christina's Cupcakes \n3) "
				+ "View Cupcakes By Flavor \n4) "
				+ "Add New Cupcake \n5)Exit" + "\nPlease enter the number of your selection: ");
	}
	
	public static void printBusinessInformation() {
		System.out.println("Christina's Cupcakes is a home bakery founded by"
				+ " Christina in 2022. It was a spur of the moment decision prompted"
				+ " by her lovely batch saying that she makes really good cupcakes.");
	}
	
	public static void printItem(Object item) {
		if(item instanceof Iterable) {
			Iterable iterable = (Iterable) item;
			for(Object o : iterable) {
				System.out.println(o);
			}
		}else if(item instanceof Object[]) {
			Object[] array = (Object[]) item;
			for(Object o : array) {
				System.out.println(o);
			}
		}else System.out.println(item);
	}
	
	public static void sayBye() {
		System.out.println("Bye bye!");
	}
	
	public static void askWhichFlavors() {
		System.out.println("Which flavor would you like to view: ");
	}
	
	public static int handleUserSelection(Scanner scanner) {
		int userSelection = 0;
		try {
			userSelection = scanner.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Sorry, that is not a valid number.");
		}
		scanner.nextLine(); // Leaving this here as there is a newline character in the stream
		return userSelection;
	}
	
	public static Cupcake getCupcakeInformation(Scanner scanner) {
		/*
		 * Yes, you should be doing some exception and validating the user inputs.
		 */
		Cupcake cupcake = new Cupcake();
		System.out.println("Enter your new cupcake information: ");
		System.out.println("Cupcake Flavor: ");
		cupcake.setCupcakeFlavor(scanner.nextLine());
		System.out.println("Enter the Cupcake's Cost: ");
		cupcake.setCost(scanner.nextFloat());
		System.out.println("Enter Bakery ID: ");
		cupcake.setBakery(scanner.nextInt());
		System.out.println("Enter Cupcake Calories: ");
		cupcake.setCalories(scanner.nextInt());
		System.out.println("Is it Gluten Free? Type true/false: ");
		cupcake.setGlutenFree(Boolean.parseBoolean(scanner.nextLine()));
		System.out.println("Is it vegan? Type true/false: ");
		cupcake.setVegan(Boolean.parseBoolean(scanner.nextLine()));
		return cupcake;
	}
}
