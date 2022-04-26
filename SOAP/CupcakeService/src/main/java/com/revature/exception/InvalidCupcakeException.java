package com.revature.exception;

/*
 * In order to create your own custom exception, you should create a class that extends the Exception class.
 * 
 * Note that if you extend just Exception, your exception will be a checked exception, meaning that you will be forced to handle
 * it should it ever be possible for it to be thrown (e.g. you must use a try-catch block).
 * 
 * If you want to make an unchecked exception (runtime exceptions), you should extend the RuntimeException class, which is a 
 * child class of Exception.
 */
public class InvalidCupcakeException extends Exception{

	public InvalidCupcakeException(String message) {
		
	}
}
