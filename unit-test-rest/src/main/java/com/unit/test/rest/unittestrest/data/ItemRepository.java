package com.unit.test.rest.unittestrest.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.unit.test.rest.unittestrest.model.Item;

@Component
public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	
	
}
