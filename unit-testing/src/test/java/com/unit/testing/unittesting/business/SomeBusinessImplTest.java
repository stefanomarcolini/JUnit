package com.unit.testing.unittesting.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SomeBusinessImplTest {

	@Test
	public void testCalculateSum_basic() {
		
		SomeBusinessImpl business = new SomeBusinessImpl();
		
		int actual = business.calculateSum(new int[] {1, 2, 3});
		
		int expected = 6;
		
		assertEquals(expected, actual);
	}

	@Test
	public void testCalculateSum_empty() {
		
		SomeBusinessImpl business = new SomeBusinessImpl();
		
		int actual = business.calculateSum(new int[] {});
		
		int expected = 0;
		
		assertEquals(expected, actual);
	}

	@Test
	public void testCalculateSum_oneValue() {
		
		SomeBusinessImpl business = new SomeBusinessImpl();
		
		int actual = business.calculateSum(new int[] {5});
		
		int expected = 5;
		
		assertEquals(expected, actual);
	}

}
