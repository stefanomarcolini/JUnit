package com.unit.test.rest.unittestrest.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.unit.test.rest.unittestrest.annotaions.IntegrationTest;

@IntegrationTest
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
class ItemControllerTestIT {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	@LocalServerPort
	void testGetDummyItem() throws JSONException {
		String response = restTemplate.getForObject("/dummy-item", String.class);
		JSONAssert.assertEquals("{id:1}", response, false);
	}

	@Test
	void testGetItemFromBusinessService() throws JSONException {
		String response = restTemplate.getForObject("/item-from-business-service", String.class);
		JSONAssert.assertEquals("{id:1}", response, false);
	}

	@Test
	void testRetrieveAllItems() throws JSONException {
		String response = restTemplate.getForObject("/all-items-from-database", String.class);
		JSONAssert.assertEquals("[{id:10001},{id:10002},{id:10003}]", response, false);
	}

}
