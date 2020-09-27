package com.unit.testing.unittesting.business;

import com.unit.testing.unittesting.data.SomeDataService;

public class SomeBusinessImpl {
	
	private SomeDataService someDataService;
	
	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(int[] data) {
		int sum = 0;
		for (int val : data)  {
			sum += val;
		}
		return sum;
	}
	
	public int calculateSumUsingDataService() {
		int sum = 0;
		int[] data = someDataService.retrieveAllData();
		for (int val : data)  {
			sum += val;
		}
		return sum;
	}
	
//	public void calculateAndStoreSumUsingDataService() {
//		int sum = 0;
//		int[] data = someDataService.retrieveAllData();
//		for (int val : data)  {
//			sum += val;
//		}
//		someDataService.storeSum(sum);
//	}

}
