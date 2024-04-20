package com.arjun.revision;

import java.util.List;

public class FP02Structured {
	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(11,10,2,5,3,6,8,9,10);
		printSum(numbers);
	}
	
	
	private static int printSum(List<Integer> numbers) {
		int sum =0;
		for (Integer number : numbers) {
			sum += number;
			
		}
		return sum;
	}
}
