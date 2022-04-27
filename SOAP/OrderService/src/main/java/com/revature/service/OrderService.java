package com.revature.service;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.revature.model.Order;

@WebService
public interface OrderService {

	List<Order> findAll();
	void save(Order order, Map<String, Integer> items);
	void contactCupcakeService(String message);
}
