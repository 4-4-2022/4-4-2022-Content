package com.revature.model;

public class Cookie extends Dessert {

	private String cookieFlavor;
	private boolean isChewy;
	private boolean containsNuts;
	private String cookieShape;
	private String cookieToppings;

	public Cookie(String cookieFlavor, boolean isChewy, boolean containsNuts, String cookieShape,
			String cookieToppings) {
		super();
		this.cookieFlavor = cookieFlavor;
		this.isChewy = isChewy;
		this.containsNuts = containsNuts;
		this.cookieShape = cookieShape;
		this.cookieToppings = cookieToppings;
	}

	public Cookie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cookie(int calories, boolean isGlutenFree, boolean isVegan) {
		super(calories, isGlutenFree, isVegan);
		// TODO Auto-generated constructor stub
	}

	public String getCookieFlavor() {
		return cookieFlavor;
	}

	public void setCookieFlavor(String cookieFlavor) {
		this.cookieFlavor = cookieFlavor;
	}

	public boolean isChewy() {
		return isChewy;
	}

	public void setChewy(boolean isChewy) {
		this.isChewy = isChewy;
	}

	public boolean isContainsNuts() {
		return containsNuts;
	}

	public void setContainsNuts(boolean containsNuts) {
		this.containsNuts = containsNuts;
	}

	public String getCookieShape() {
		return cookieShape;
	}

	public void setCookieShape(String cookieShape) {
		this.cookieShape = cookieShape;
	}

	public String getCookieToppings() {
		return cookieToppings;
	}

	public void setCookieToppings(String cookieToppings) {
		this.cookieToppings = cookieToppings;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (containsNuts ? 1231 : 1237);
		result = prime * result + ((cookieFlavor == null) ? 0 : cookieFlavor.hashCode());
		result = prime * result + ((cookieShape == null) ? 0 : cookieShape.hashCode());
		result = prime * result + ((cookieToppings == null) ? 0 : cookieToppings.hashCode());
		result = prime * result + (isChewy ? 1231 : 1237);
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
		Cookie other = (Cookie) obj;
		if (containsNuts != other.containsNuts)
			return false;
		if (cookieFlavor == null) {
			if (other.cookieFlavor != null)
				return false;
		} else if (!cookieFlavor.equals(other.cookieFlavor))
			return false;
		if (cookieShape == null) {
			if (other.cookieShape != null)
				return false;
		} else if (!cookieShape.equals(other.cookieShape))
			return false;
		if (cookieToppings == null) {
			if (other.cookieToppings != null)
				return false;
		} else if (!cookieToppings.equals(other.cookieToppings))
			return false;
		if (isChewy != other.isChewy)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cookie [cookieFlavor=" + cookieFlavor + ", isChewy=" + isChewy + ", containsNuts=" + containsNuts
				+ ", cookieShape=" + cookieShape + ", cookieToppings=" + cookieToppings + "]";
	}

	@Override
	public void cook() {
		// TODO Auto-generated method stub

	}

}
