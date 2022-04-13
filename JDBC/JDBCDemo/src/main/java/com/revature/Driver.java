//The package declaration MUST be present.
package com.revature;

import java.util.Scanner;

import com.revature.client.AppUI;
import com.revature.model.Cupcake;
import com.revature.service.CupcakeService;

public class Driver {

	public static void main(String[] args) {
		
		
		/*
		 * Let's just go ahead and grab the existing cupcakes right off the bat.
		 */
		CupcakeService cupcakeService = new CupcakeService();
		
		/*
		 * I need to get the user input now. Note that scanner is a text scanner that we
		 * use to parse input. It is frequently used with the standard input stream
		 * (System.in) in order to parse user input.
		 * 
		 * Please be careful with the scanner class as 1) once you've closed a Scanner
		 * that is wrapped around standard input, you'll close that stream and 2)
		 * sometimes leftover characters/data could end up sitting in the stream so you
		 * have to remember to consume this data.
		 */

		Scanner scanner = new Scanner(System.in);

		/*
		 * Let's say that this was a cupcake shop and that a user wanted to use this
		 * application to buy cupcakes. We will loop until the user indicates that
		 * they're no longer interested in using the application.
		 * 
		 * We'll have a flag (a boolean variable) will determine whether or not the loop
		 * keeps running.
		 * 
		 * 
		 */
		boolean isUserInterested = true;

		while (isUserInterested) {
			AppUI.printWelcomeMenu();
			int userSelection =AppUI.handleUserSelection(scanner);

			switch (userSelection) {
			case 1:
				AppUI.printItem(cupcakeService.findAllCupcakes());
				break;
			case 2:
				AppUI.printBusinessInformation();
				break;
			case 3:
				AppUI.askWhichFlavors();
				System.out.println(cupcakeService.findCupcakesByFlavor(cupcakeService.takeCupcakeInfo(scanner)));
				break;
			case 4:
				Cupcake newCupcake = AppUI.getCupcakeInformation(scanner);
				cupcakeService.save(newCupcake);
				break;
			case 5:
				AppUI.sayBye();
				isUserInterested = false;
				break;
			default:
				break;
			}
		}

		scanner.close();

	}
}
