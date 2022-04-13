package com.revature.client;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppUI {

	/*
	 * I've made this method static because I do not want to create an instance of this class just to call this simple print method.
	 */
	public static void printWelcomeMenu() {
		System.out.println(
				"Welcome, user! What would you like to do?\n"
				+ "1) View Cupcakes \n2) About Christina's Cupcakes \n3) View Cupcakes By Flavor \n4) Exit " + "\nPlease enter the number of your selection: ");
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
}
