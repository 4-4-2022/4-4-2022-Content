package com.revature.model;

/*
 * My cupcake class is a template/blueprint for individual cupcakes. I'm specifying
 * the properties of cupcakes (e.g. cost, flavor, bakery associated with the cupcake).
 * 
 * Note that we've made this class a "Java Bean". A Java Bean simply follows a design
 * pattern (is itself a design pattern). A Java Bean includes:
 * 
 * - A Constructor Using Fields
 * - A No-Args Constructor
 * - Getters and Setters
 * - A Hashcode method
 * - An equals method
 * - A toString method
 * - Technically speaking, Java Beans should also implement the Serializable interface.
 * 
 * Note also that we have made Cupcake a Dessert by extending the Dessert class. This means that cupcake inherits properties
 * and methods from Dessert. Keep in mind that a class in Java can only extend one class. This is why we say that Java does not
 * support multiple inheritance.
 * 
 * We have additionally made this class implement the Comparable interface because we need to define a "natural order" for
 * cupcakes as Java has no idea how to sort cupcakes.
 * 
 *Comparator
 */
public class Cupcake extends Dessert implements Edible, Comparable<Cupcake>{
	/*
	 * These are instance variables. They are accessible throughout the entire class.
	 * They don't have to be initialized because they receive default values.
	 * The default values are the simplest possible. Object types are "null" by
	 * default. Primitive data types(boolean, byte, char, short, int, long, float, double).
	 * 
	 * Please pay attention to the access modifiers. They determine how accessible/visible
	 * a member of a class (or even a class itself) is. 
	 * 
	 * Public is the most accessible; a public member is directly accessible 
	 * everywhere in the source code.
	 * 
	 * Protected is very accessible in that it allows for direct access from within
	 * the same package and within subclasses of this type (Cupcake).
	 * 
	 * Default is less accessible in that it only allows for direct access from
	 * within the same package. It is often called "package private". Interestingly
	 * enough, you cannot write "default" this level of access; just don't include
	 * a written modifier.
	 * 
	 * Private is the most restrictive of all modifiers in that it only allows for direct
	 * access to a member from within the class in which that member is declared.
	 */
	private String cupcakeFlavor;
	private short cost;
	/*
	 * Because of the paradigm mismatch between SQL and Java, you might sometimes find yourself
	 * representing data in "strange" ways as this field goes against the idea of using an OOP
	 * language to represent data.
	 */
	private int bakery_id;
	/**
	 * This variable is static and will be used to count the number of cupcake instances that are created in this application. When
	 * a member of a class is static, it is shared across all instances of that class. That is to say, there will only ever be ONE copy of
	 * cupcakeCount variable. We've made it public so that we can easily access it elsewhere.
	 */
	public static int cupcakeCount;
	
	/*
	 * By default, Java provides you with a "default constructor" for every class you
	 * create IF you do not create your own constructor for the class. We use a constructor
	 * to initialize an instance of a class. The minute you create your own
	 * constructor, you're no longer using the default constructor.
	 * 
	 * Note that constructors don't have return types. This is a no-args constructor
	 * because it has no parameters.
	 */
	public Cupcake() {
		//This is always implied to be the first line of any constructor.
		super();
		cupcakeCount++;
	}
	
	/*
	 * This is an overload of our constructor that uses the class's fields.
	 */
	public Cupcake(String cupcakeFlavor, short cost, int bakery_id, int calories, boolean isGlutenFree, boolean isVegan) {
		super(calories, isGlutenFree, isVegan);
		this.cupcakeFlavor = cupcakeFlavor;
		this.cost = cost;
		this.bakery_id = bakery_id;
		cupcakeCount++;
	}
	
	/*
	 * In order to provide indirect access to private fields, we use getters and
	 * setters. These are just methods that allow the caller to indirectly write to
	 * or read from fields.
	 */
	
	public String getCupcakeFlavor() {
		return cupcakeFlavor;
	}

	public void setCupcakeFlavor(String cupcakeFlavor) {
		this.cupcakeFlavor = cupcakeFlavor;
	}

	public short getCost() {
		return cost;
	}

	public void setCost(short cost) {
		this.cost = cost;
	}

	public int getBakery() {
		return bakery_id;
	}

	public void setBakery(int bakery_id) {
		this.bakery_id = bakery_id;
	}

	/*
	 * This method is inherited from the Object class.
	 */
	

	
	/*
	 * This method is used to choose a String representation of instances of this class.
	 * This method is inherited from the Object class and we are overriding it here.
	 */
	@Override
	public String toString() {
		return "Cupcake [cupcakeFlavor=" + cupcakeFlavor + ", cost=" + cost + ", bakery=" + bakery_id + ", calories=" + this.getCalories() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bakery_id;
		result = prime * result + cost;
		result = prime * result + ((cupcakeFlavor == null) ? 0 : cupcakeFlavor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cupcake other = (Cupcake) obj;
		if (bakery_id != other.bakery_id)
			return false;
		if (cost != other.cost)
			return false;
		if (cupcakeFlavor == null) {
			if (other.cupcakeFlavor != null)
				return false;
		} else if (!cupcakeFlavor.equals(other.cupcakeFlavor))
			return false;
		return true;
	}

	/*
	 * This MUST be overridden because it is an inherited abstract method.
	 */
	@Override
	public void cook() {
		System.out.println("Something specific to cooking cupcakes.");
		
	}

	@Override
	public void provideNutrients() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * We must implement this method in a such a way that it reflects what we think makes one cupcake "greater" or "less" than another
	 * cupcake.
	 */
	@Override
	public int compareTo(Cupcake o) {
		return this.cost - o.cost;
	}
	
}
