package com.revature.client;

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
}
