package com.revature.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

@Table(name = "quantity")
public class Item {

	@EmbeddedId
	OrderFlavorKey key;
	@Column(name = "quantity")
	private int quantity;

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(OrderFlavorKey key, int quantity) {
		super();
		this.key = key;
		this.quantity = quantity;
	}

	public OrderFlavorKey getKey() {
		return key;
	}

	public void setKey(OrderFlavorKey key) {
		this.key = key;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + quantity;
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
		Item other = (Item) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [key=" + key + ", quantity=" + quantity + "]";
	}

}
