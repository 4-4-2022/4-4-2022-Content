package com.revature.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.revature.model.Cupcake;

public class CustomKryoSerializer extends Serializer<Cupcake> {

	
	public static void main(String[] args) {
		
		Kryo kryo = new Kryo();
		Output output = new Output(System.out);
		Cupcake cupcake = new Cupcake("Champagne Cake", (short) 3, "Sugar Bee Sweets", 100, true, true);
		CustomKryoSerializer customSerializer = new CustomKryoSerializer();
		customSerializer.write(kryo, output, cupcake);
		output.close();
	}

	/*
	 * If you are building a custom serializer, you will be responsible for specifying how the object needs to be written...
	 */
	@Override
	public void write(Kryo kryo, Output output, Cupcake object) {
		output.writeString("The " + object.getCupcakeFlavor() +" has been written as: " + object.getBakery() + "," 
	+ object.getCost() + "," + object.getCalories());
	}

	/*
	 * ...and how it needs to be read back in.
	 */
	@Override
	public Cupcake read(Kryo kryo, Input input, Class<? extends Cupcake> type) {
		// TODO Auto-generated method stub
		return null;
	}
}
