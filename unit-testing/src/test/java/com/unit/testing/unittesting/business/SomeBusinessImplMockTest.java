package com.unit.testing.unittesting.business;

import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.unit.testing.unittesting.data.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessImplMockTest {

	@InjectMocks
	private SomeBusinessImpl business;// = new SomeBusinessImpl();
	@Mock
	private SomeDataService dataServiceMock;// = mock(SomeDataService.class);
	
//	@Before
//	public void init() {
//		business.setSomeDataService(dataServiceMock);
//	}

	@Test
	public void testCalculateSumUsingDataService_basic() {
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
		assertEquals(6, business.calculateSumUsingDataService());
	}

	@Test
	public void testCalculateSumUsingDataService_empty() {
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(0, business.calculateSumUsingDataService());
	}

	@Test
	public void testCalculateSumUsingDataService_oneValue() {
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
		assertEquals(5, business.calculateSumUsingDataService());
	}

}
