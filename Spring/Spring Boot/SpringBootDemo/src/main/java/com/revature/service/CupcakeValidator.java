package com.revature.service;

import com.revature.exception.InvalidCupcakeException;
import com.revature.model.Cupcake;

public class CupcakeValidator {

	public void validateCupcake(Cupcake cupcake) {
		if(cupcake.getCupcakeFlavor().length() < 1) {
			try {
				throw new InvalidCupcakeException("Invalid Cupcake Property Specified");
			}catch(InvalidCupcakeException e) {
				e.printStackTrace();
			}
		}
	}
}
