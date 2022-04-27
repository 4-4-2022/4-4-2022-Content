package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import com.revature.model.Order;

@WebService
public interface OrderService {

	List<Order> findAll();
	void save(Order order);
	void contactCupcakeService(String message);
}
