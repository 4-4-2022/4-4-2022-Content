//The package declaration MUST be present.
package com.revature;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import com.revature.client.AppUI;
/*
 * If a type is in a different package, it must be imported in order to be used
 * here. You MUST use the fully qualified class name.
 */
import com.revature.model.Cupcake;
import com.revature.repository.CupcakeRepository;
import com.revature.repository.CupcakeRepositoryImpl;
import com.revature.service.CupcakeService;

public class Driver {

	public static void main(String[] args) {

		/*
		 * Let's just go ahead and grab the existing cupcakes right off the bat.
		 */
		CupcakeRepository cupcakeRepository = new CupcakeRepositoryImpl();
		CupcakeService cupcakeService = new CupcakeService();
		Set<Cupcake> cupcakes = cupcakeRepository.findAllCupcakes();

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
		 */
		boolean isUserInterested = true;

		while (isUserInterested) {
			AppUI.printWelcomeMenu();
			int userSelection = 0;

			try {
				userSelection = scanner.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Sorry, that is not a valid number.");
			}
			scanner.nextLine(); // Leaving this here as there is a newline character in the stream

			switch (userSelection) {
			case 1:
				for (Cupcake cupcake : cupcakes) {
					System.out.println(cupcake);
				}
				break;
			case 2:
				AppUI.printBusinessInformation();
				break;
			case 3:
				System.out.println("Which flavor would you like to view: ");
				System.out.println(cupcakeService.findCupcakesByFlavor(scanner));
				break;
			case 4:
				System.out.println("Bye bye!");
				isUserInterested = false;
				break;
			default:
				break;
			}
		}

		scanner.close();

	}
}
