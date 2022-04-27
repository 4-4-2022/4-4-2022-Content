package com.revature.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author 17084
 *
 */
@Entity

@Table(name = "orders")
public class Order {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "order_id_seq")
	@SequenceGenerator(allocationSize = 1, name = "order_id_seq")
	private int id;
	@Column(name = "user_id")
	private int user_id;
	@Column(name = "status")
	private String status;
	@ManyToMany
	@JoinTable
	private Set<OrderQuantity> orderQuanity;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int id, int user_id, String status, Set<OrderQuantity> orderQuanity) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.status = status;
		this.orderQuanity = orderQuanity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<OrderQuantity> getOrderQuanity() {
		return orderQuanity;
	}

	public void setOrderQuanity(Set<OrderQuantity> orderQuanity) {
		this.orderQuanity = orderQuanity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((orderQuanity == null) ? 0 : orderQuanity.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + user_id;
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
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		if (orderQuanity == null) {
			if (other.orderQuanity != null)
				return false;
		} else if (!orderQuanity.equals(other.orderQuanity))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", user_id=" + user_id + ", status=" + status + ", orderQuanity=" + orderQuanity
				+ "]";
	}

}
