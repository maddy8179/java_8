package com.arjun.revision;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03Exercise3 {
//	List<Integer> squareNumbers = numbers.stream().map(x -> x*x).collect(Collectors.toList());

	public static void main(String[] args) {
		List<Integer> numbers = List.of(11,10,2,5,3,6,5,8,9,10);
		
		//List<Integer> squareNumbers = numbers.stream().map(x -> x*x).collect(Collectors.toList());
		Function<Integer, Integer> function = x -> x*x;
		System.out.println(mapAndCreate(numbers, function));
		List<Integer> cubedNumbers = mapAndCreate(numbers, x -> x*x*x);
		List<Integer> doubleNumbers = mapAndCreate(numbers, x -> x+x);
		
		System.out.println(cubedNumbers);
		System.out.println(doubleNumbers);
		
		
	}
	
	private static List<Integer> mapAndCreate(List<Integer> numbers, Function<Integer, Integer> function){
		return numbers.stream().map(function).collect(Collectors.toList());
	}
	

}
