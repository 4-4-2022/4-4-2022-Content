package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@Table(name = "order_quantity")
public class OrderQuantity {

	@Id
	@Column
	@GeneratedValue(generator = "order_quantity_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "order_quantity_seq")
	private int id;
	@Column(name = "cupcake_flavor")
	private String cupcakeFlavor;
	@Column(name = "quantity")
	private int quantity;
}
