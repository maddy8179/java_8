package com.arjun.revision;

import java.util.List;

public class FP01Structuredr {

	public static void main(String[] args) {
		//printNumbers(List.of(11,10,2,5,3,6,8,9,10));
		List<Integer> numbers = List.of(11,10,2,5,3,6,8,9,10);
		
		printNumbers(numbers);
		
		printEvenNumbers(numbers);
	}
	private static void printNumbers(List<Integer> numbers) {
		for (Integer number : numbers) {
			System.out.print(number+ " ");
		}
	}
	
	
	private static void printEvenNumbers(List<Integer> numbers) {
		for (Integer number : numbers) {
			if(number%2 ==0) {
				System.out.println(number);
			}
		}
	}

}
