//The package declaration MUST be present.
package com.revature;

import java.util.Scanner;

/*
 * If a type is in a different package, it must be imported in order to be used
 * here. You MUST use the fully qualified class name.
 */
import com.revature.model.Cupcake;
import com.revature.model.Dessert;
import com.revature.model.Edible;
import com.revature.repository.CupcakeRepository;
import com.revature.repository.CupcakeRepositoryImpl;

public class Driver {

	public static void main(String[] args) {
		
		/*
		 * Let's just go ahead and grab the existing cupcakes right off the bat.
		 */
		CupcakeRepository cupcakeRepository = new CupcakeRepositoryImpl();
		Cupcake[] cupcakes = cupcakeRepository.findAllCupcakes();
		
		Dessert dessert = new Cupcake();
		Edible dessert2 = new Cupcake();
		
		System.out.println(cupcakes[0]);
		
		/*
		 * I need to get the user input now. Note that scanner is a text
		 * scanner that we use to parse input. It is frequently used with the
		 * standard input stream (System.in) in order to parse user input.
		 * 
		 * Please be careful with the scanner class as 1) once you've closed a
		 * Scanner that is wrapped around standard input, you'll close that
		 * stream and 2) sometimes leftover characters/data could end up sitting
		 * in the stream so you have to remember to consume this data.
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		/*
		 * Let's say that this was a cupcake shop and that a user wanted to use this
		 * application to buy cupcakes. We will loop until the user indicates that they're no longer
		 * interested in using the application.
		 * 
		 * We'll have a flag (a boolean variable) will determine whether or not the loop keeps running.
		 */
		boolean isUserInterested = false;
		
//		while(isUserInterested) {
//		AppUI.printWelcomeMenu();
//		
//		int userSelection = scanner.nextInt();
//		scanner.nextLine(); //Leaving this here as there is a newline character in the stream
//		
//		switch(userSelection) {
//		case 1:
//			for (Cupcake cupcake : cupcakes) {
//				System.out.println(cupcake);
//			}
//			break;
//		case 2:
//			AppUI.printBusinessInformation();
//			break;
//		case 3: 
//			System.out.println("Bye bye!");
//			isUserInterested = false;
//			break;
//		default:
//			System.out.println("Okay. Seriously. That's not a menu option.");
//		}
//		}

		scanner.close();
		
	}
}
