package com.revature.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import com.revature.model.Cupcake;

/*
 * The Kryo library actually has a default serialization format that you can easily use.
 */
public class StandardKryoSerialization {

	public static void main(String[] args) {
		
		//This class is standard in the Kryo library.
		Kryo kryo = new Kryo();
		//We're targeting the Cupcake class for serialization.
		kryo.register(Cupcake.class);
		
		//This is the cupcake we will serialize.
		Cupcake cupcake = new Cupcake("Champagne Cake", (short) 3, "Sugar Bee Sweets", 100, true, true);
		
		//Specify my output stream, which is STDOUT
		Output output = new Output(System.out);
		kryo.writeObject(output, cupcake);
		output.close();
	}
	
}
