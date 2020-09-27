package com.unit.testing.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class ListMockTest {

	@SuppressWarnings("unchecked")
	private List<String> mock = mock(List.class);
	
	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	public void returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	
	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("Hello");
		assertEquals("Hello", mock.get(0));
		assertEquals(null, mock.get(1));
		assertEquals(null, mock.get(2));
		//...
	}
	
	@Test
	public void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("Hello");
		assertEquals("Hello", mock.get(0));
		assertEquals("Hello", mock.get(1));
		assertEquals("Hello", mock.get(2));
		//...
	}
	
	@Test
	public void verificationBasics() {
		// System Under Test (SUT)
		mock.get(0);
		
		// Verify method has been called
		verify(mock).get(0);
		verify(mock).get(anyInt());
		verify(mock, times(1)).get(anyInt());
	}
	
	@Test
	public void verificationAdvanced() {
		// System Under Test (SUT)
		mock.get(0);
		mock.get(1);
		
		// Verify method has been called
		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);
	}
	
	@Test
	public void argumentCapturing() {
		// given SUT
		mock.add("SomeStringArg");
		
		// Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		
		//	test
		assertEquals("SomeStringArg", captor.getValue());
	}
	
	@Test
	public void multipleArgumentsCapturing() {
		// given SUT
		mock.add("SomeStringArg_0");
		mock.add("SomeStringArg_1");
		
		// Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());
		
		List<String> allValues = captor.getAllValues();
		assertEquals("SomeStringArg_0", allValues.get(0));
		assertEquals("SomeStringArg_1", allValues.get(1));
	}
	
	@Test
	public void mocking() {
		//	instead of real actions
		@SuppressWarnings("unchecked")
		ArrayList<String> arrayListMock = mock(ArrayList.class);	//	using new object for any call
		System.out.println(arrayListMock.get(0));   // null
		System.out.println(arrayListMock.size());	// 0
		arrayListMock.add("Test_0");
		arrayListMock.add("Test_1");
		System.out.println(arrayListMock.size());	// 0
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());	// 5
		System.out.println();
	}
	
	@Test
	public void spying() {
		//	interfere on real actions
		@SuppressWarnings("unchecked")
		ArrayList<String> arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Test_0");					//	using original object
		System.out.println(arrayListSpy.get(0));    // Test_0
		System.out.println(arrayListSpy.size());	// 1
		arrayListSpy.add("Test_1");
		arrayListSpy.add("Test_2");
		System.out.println(arrayListSpy.size());	// 3
		when(arrayListSpy.size()).thenReturn(5);	//	taking control on spy output (overriding spy object values)
		System.out.println(arrayListSpy.size());	// 5
		arrayListSpy.add("Test_3");
		System.out.println(arrayListSpy.size());	// 5
		
		verify(arrayListSpy).add("Test_3");
		System.out.println();
	}
	
}
