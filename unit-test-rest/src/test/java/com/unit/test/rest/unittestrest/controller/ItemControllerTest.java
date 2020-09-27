package com.unit.test.rest.unittestrest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.unit.test.rest.unittestrest.annotaions.UnitTest;
import com.unit.test.rest.unittestrest.business.ItemBusinessService;
import com.unit.test.rest.unittestrest.model.Item;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ItemController.class)
@UnitTest
public class ItemControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService businessService;
	
	@Test
	public void testGetDummyItem() throws Exception {

		// call -> GET /dummy-item   application/json
		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item")
													   .accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
								  .andExpect(status().isOk())
								  .andExpect(content().contentType(MediaType.APPLICATION_JSON))
								  //exact match
								  .andExpect(content().string("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100,\"value\":0}"))
								  //json content <k, v> match
								  .andExpect(content().json("{\"id\" : 1,\"name\" : \"Ball\",\"price\" : 10,\"quantity\" : 100, value:0}"))
								  .andReturn();
		
		// verify -> "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"
		assertEquals("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100,\"value\":0}", result.getResponse().getContentAsString());
//		JSONAssert.assertEquals(expected, actual, false);
	}
	
	@Test
	public void testGetItemFromBusinessService() throws Exception {
		
		when(businessService.retrieveHardcodedItem()).thenReturn(new Item(2, "Item 2", 10, 10));
		
		// call -> GET /item-from-business-service   application/json
		RequestBuilder request = MockMvcRequestBuilders.get("/item-from-business-service")
													   .accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
								  .andExpect(status().isOk())
								  .andExpect(content().contentType(MediaType.APPLICATION_JSON))
								  //exact match
								  .andExpect(content().string("{\"id\":2,\"name\":\"Item 2\",\"price\":10,\"quantity\":10,\"value\":0}"))
								  //json content <k, v> match
								  .andExpect(content().json("{\"id\" : 2,\"name\" : \"Item 2\",\"price\" : 10,\"quantity\" : 10, value:0}"))
								  .andReturn();
		
		// verify -> "{\"id\":2,\"name\":\"Item 2\",\"price\":10,\"quantity\":10}"
		assertEquals("{\"id\":2,\"name\":\"Item 2\",\"price\":10,\"quantity\":10,\"value\":0}", result.getResponse().getContentAsString());
//		JSONAssert.assertEquals(expected, actual, false);
	}
	
	@Test
	public void testRetrieveAllItems_basics() throws Exception {
		
		when(businessService.retrieveAllItems()).thenReturn(Arrays.asList(
						new Item(2, "Item 2", 10, 10),
						new Item(3, "Item 3", 20, 20)
					)
				);
		
		// call -> GET /all-items-from-database   application/json
		RequestBuilder request = MockMvcRequestBuilders.get("/all-items-from-database")
													   .accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
								  .andExpect(status().isOk())
								  .andExpect(content().contentType(MediaType.APPLICATION_JSON))
								  //exact match
								  .andExpect(content().string("[{\"id\":2,\"name\":\"Item 2\",\"price\":10,\"quantity\":10,\"value\":0},"
								  		+ "{\"id\":3,\"name\":\"Item 3\",\"price\":20,\"quantity\":20,\"value\":0}]"))
								  //json content <k, v> match
								  .andExpect(content().json("[{\"id\" : 2,\"name\" : \"Item 2\",\"price\" : 10,\"quantity\" : 10, value:0},"
								  		+ "{\"id\":3,\"name\":\"Item 3\",\"price\":20,\"quantity\":20,\"value\":0}]"))
								  .andReturn();
		
		// verify -> "[{\"id\":2,\"name\":\"Item 2\",\"price\":10,\"quantity\":10,\"value\":0},{\"id\":3,\"name\":\"Item 3\",\"price\":20,\"quantity\":20,\"value\":0}]"
		assertEquals("[{\"id\":2,\"name\":\"Item 2\",\"price\":10,\"quantity\":10,\"value\":0},{\"id\":3,\"name\":\"Item 3\",\"price\":20,\"quantity\":20,\"value\":0}]", result.getResponse().getContentAsString());
//		JSONAssert.assertEquals(expected, actual, false);
	}

}
