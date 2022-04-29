package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Item;

@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<Item, Integer>{

	<S extends Item> S save(S entity);
}
