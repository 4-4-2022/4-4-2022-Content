package com.revature;
//This is a single-line comment.
/*
 * This is a multiline comment that is designed to span multiple lines. It is
 * preferred when your comments are longer.
 */

/**
 * Please note that this type of comment generates Java documentation.
 * 
 * Java is an object-oriented programming language. If you want to create an
 * object, you need a class that serves as a blueprint. This means that we need
 * create a class.
 * 
 * Within a Java file, you can only have ONE public class. You can have multiple
 * classes, but only one can public. The public class's MUST match the file name
 * (minus the .java extension).
 * 
 * Also note that is conventional to start class names with capital letters.
 */
public class HelloWorld{
	/**
	 * This is what we refer to as the "main method". Yes, it has to be called
	 * "main". Your main method serves as the entrypoint into your application.
	 * That is to say, this is where your application begins execution.
	 * @param args this parameter denotes any arguments that are passed into this method from the command line
	 * 
	 * Note that method names and parameters should start with lowercase letters
	 * by convention.
	 */
	public static void main(String[] args) {
		
		/*
		 * This is a statement. It gives an instruction to my computer. It must
		 * end with a semicolon.
		 */
		System.out.println("Hello world!");
	}
}
