package com.arjun.revision;

import java.util.List;

public class FP02Functionalr {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(11,10,2,5,3,6,8,9,10);
		//int sum = printSum(numbers);
		//System.out.println(sum);
		
		System.out.println(jshell1(numbers));
	}
	
	private static int sum(int aggregator, int nextNumber) {
		System.out.println(aggregator + " " + nextNumber);
//		0 11
//		11 10
//		21 2
//		23 5
//		28 3
//		31 6
//		37 8
//		45 9
//		54 10
//		64
		return aggregator+nextNumber;//aggregator  //nextNumber
	}
	private static int printSum(List<Integer> numbers) {
		return numbers.stream()
			//combine all stream of numbers into one result => one value
			//start with 0 and (a+b) -> a+b given two numbers add to them FP02Functionalr::sum
			.reduce(0, FP02Functionalr::sum);
			//.reduce(0, (x,y) -> x+y);
			//.reduce(0, Integer::sum);
	}
	
	private static int jshell1(List<Integer> numbers) {
		//jshell
		//max value
		//return numbers.stream().reduce(0, (x,y)-> x>y?x:y);
		//return numbers.stream().reduce(Integer.MIN_VALUE, (x,y)-> x>y?x:y);
		
		//min value
		return numbers.stream().reduce(Integer.MAX_VALUE, (x,y)-> x>y?y:x);
	}
}
