package com.unit.test.rest.unittestrest.business;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.unit.test.rest.unittestrest.annotations.UnitTest;
import com.unit.test.rest.unittestrest.data.ItemRepository;
import com.unit.test.rest.unittestrest.model.Item;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
@SpringBootTest
@UnitTest
class ItemBusinessServiceTest {
	
	@InjectMocks
	private ItemBusinessService business;
	
	@Mock
	private ItemRepository repository;

	@Test
	void testRetrieveHardcodedItem() {
		Item actual = business.retrieveHardcodedItem();
		Item expected = new Item(1, "Ball", 10, 100);
		
		assertTrue(Objects.equals(expected, actual));
	}

	@Test
	void testRetrieveAllItems_basic() {
		
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(2, "Item2", 10, 10),
				new Item(3, "Item3", 20, 20)));
		
		List<Item> items = business.retrieveAllItems();
		
		assertEquals(100, items.get(0).getValue());
		assertEquals(400, items.get(1).getValue());
	}

}
