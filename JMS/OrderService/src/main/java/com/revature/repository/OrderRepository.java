package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Order;

@Repository("orderRepository")
public interface OrderRepository extends JpaRepository<Order, Integer>{

	List<Order> findAll();
	<S extends Order> S save(S entity);
}
