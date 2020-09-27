package com.unit.test.rest.unittestrest.data;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.unit.test.rest.unittestrest.annotations.UnitTest;
import com.unit.test.rest.unittestrest.model.Item;

@RunWith(SpringRunner.class)
@DataJpaTest
@UnitTest
class ItemRepositoryTest {
	
	@Autowired
	ItemRepository repository;
	
	@Test
	void testFindAll() {
		List<Item> items = repository.findAll();
		
		assertEquals(3, items.size());
	}
	
	@Test
	void testFindItemById() {
		Optional<Item> actual = repository.findById(10001);
		Item expected = new Item(10001,"Item1",10,20);
		assertTrue(Objects.equals(expected, actual.get()));
	}

}
