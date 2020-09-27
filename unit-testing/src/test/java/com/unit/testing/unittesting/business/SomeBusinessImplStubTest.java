package com.unit.testing.unittesting.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.unit.testing.unittesting.data.SomeDataService;

class SomeDataServiceStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] {1, 2, 3};
	}
	
}
class SomeDataServiceEmptyStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}
	
}
class SomeDataServiceOneValueStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] {5};
	}
	
}

public class SomeBusinessImplStubTest {

	@Test
	public void testCalculateSumUsingDataService_basic() {
		
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		
		int actual = business.calculateSumUsingDataService();
		
		int expected = 6;
		
		assertEquals(expected, actual);
	}

	@Test
	public void testCalculateSumUsingDataService_empty() {
		
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceEmptyStub());
		
		int actual = business.calculateSumUsingDataService();
		
		int expected = 0;
		
		assertEquals(expected, actual);
	}

	@Test
	public void testCalculateSumUsingDataService_oneValue() {
		
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceOneValueStub());
		
		int actual = business.calculateSumUsingDataService();
		
		int expected = 5;
		
		assertEquals(expected, actual);
	}

}
