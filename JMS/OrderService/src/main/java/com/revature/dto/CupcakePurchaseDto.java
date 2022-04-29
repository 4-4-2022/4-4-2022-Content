package com.revature.dto;
import java.io.Serializable;

/*
 * This DTO (Data Transfer Object) only exists so that I have a way to easily send data from one service to
 * another.
 */
public class CupcakePurchaseDto implements Serializable{

	private static final long serialVersionUID = 5726390849800217767L;
	private String cupcakeFlavor;
	private int quantity;

	public CupcakePurchaseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CupcakePurchaseDto(String cupcakeFlavor, int quantity) {
		super();
		this.cupcakeFlavor = cupcakeFlavor;
		this.quantity = quantity;
	}

	public String getCupcakeFlavor() {
		return cupcakeFlavor;
	}

	public void setCupcakeFlavor(String cupcakeFlavor) {
		this.cupcakeFlavor = cupcakeFlavor;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
