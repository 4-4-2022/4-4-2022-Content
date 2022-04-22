package com.revature.client;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.model.Cupcake;
import com.revature.service.CupcakeService;

@Component("client")
public class ClientDriver {

	@Autowired
	public CupcakeService cupcakeService;

	public void startApp() {
		Scanner scanner = new Scanner(System.in);

		boolean isUserInterested = true;

		while (isUserInterested) {
			AppUI.printWelcomeMenu();
			int userSelection = AppUI.handleUserSelection(scanner);

			switch (userSelection) {
			case 1:
				AppUI.printItem(cupcakeService.findAllCupcakes());
				break;
			case 2:
				AppUI.printBusinessInformation();
				break;
			case 3:
//				AppUI.askWhichFlavors();
//				System.out.println(cupcakeService.findByFlavor(cupcakeService.takeCupcakeInfo(scanner)));
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
