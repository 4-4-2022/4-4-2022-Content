package com.revature.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
 * The Embeddable annotation allows us to specify that this type can be used as
 * a composite primary key.
 * 
 * Note that composite key classes must implement Serializable per documentation.
 */
@Embeddable
public class OrderFlavorKey implements Serializable {

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	@Column(name = "cupcake_flavor")
	private String cupcakeFlavor;

	public OrderFlavorKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderFlavorKey(Order order, String cupcakeFlavor) {
		super();
		this.order = order;
		this.cupcakeFlavor = cupcakeFlavor;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getCupcakeFlavor() {
		return cupcakeFlavor;
	}

	public void setCupcakeFlavor(String cupcakeFlavor) {
		this.cupcakeFlavor = cupcakeFlavor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cupcakeFlavor == null) ? 0 : cupcakeFlavor.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
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
		OrderFlavorKey other = (OrderFlavorKey) obj;
		if (cupcakeFlavor == null) {
			if (other.cupcakeFlavor != null)
				return false;
		} else if (!cupcakeFlavor.equals(other.cupcakeFlavor))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderFlavorKey [order=" + order + ", cupcakeFlavor=" + cupcakeFlavor + "]";
	}

}
