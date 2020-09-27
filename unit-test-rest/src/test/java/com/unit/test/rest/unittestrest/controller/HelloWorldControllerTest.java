package com.unit.test.rest.unittestrest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.unit.test.rest.unittestrest.annotaions.UnitTest;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloWorldController.class)
@UnitTest
public class HelloWorldControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void testHelloWorld_basic() throws Exception {

		// call -> GET /hello-world   application/json
		RequestBuilder request = MockMvcRequestBuilders.get("/hello-world")
													   .accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
								  .andExpect(status().isOk())
								  .andExpect(content().contentType(MediaType.APPLICATION_JSON))
								  .andExpect(content().string("Hello World!"))
								  .andReturn();
		
		// verify -> Hello World!
		assertEquals("Hello World!", result.getResponse().getContentAsString());
	}

}
