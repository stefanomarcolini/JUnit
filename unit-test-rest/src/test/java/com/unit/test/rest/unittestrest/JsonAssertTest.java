package com.unit.test.rest.unittestrest;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import com.unit.test.rest.unittestrest.annotations.UnitTest;

@UnitTest
public class JsonAssertTest {
	
	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
	String actualResponse1 = "{\"id\":1,\"name\":\"Ball 1\",\"price\":10,\"quantity\":100}";
	
	@Test
	public void jsonAssertStrictTrueExactMatchExceptForSpaces() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
		
		expectedResponse = "{\"id\"  :1  ,\"name\" :  \"Ball\",\"price\"   :10,\"quantity\":   100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
		
		expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}
	
	@Test
	public void jsonAssertStrictFalseExactMatchOfFoundElements() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
		
		expectedResponse = "{\"id\":  1,\"name\"    :\"Ball\",   \"price\" :  10}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}
	
	@Test
	public void jsonAssertWithoutEscapeCharacters() throws JSONException {
		String expectedResponse = "{id:1,name:Ball,price:10}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
		
		expectedResponse = "{id:  1,name    :Ball,   price :  10}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}
	
	@Test
	public void jsonAssertMandatoryEscapeCharacters() throws JSONException {
		String expectedResponse = "{id:  1,name    :\"Ball 1\",   price :  10}";
		JSONAssert.assertEquals(expectedResponse, actualResponse1, false);
	}
	
}
