package com.arjun.revision;

import java.util.List;
import java.util.function.Predicate;

public class FP03BehaviourParameterization {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(11,10,2,5,3,6,5,8,9,10);
		
/*		//after inline
		filterAndPredicate(numbers,x -> x%2==0);
	
		Predicate<? super Integer> oddPredicate = x -> x%2!=0;// extract to local variable
		filterAndPredicate(numbers, oddPredicate);
		*/
		filterAndPredicate(numbers, x -> x%3==0);//x -> x%3==0 passing logic of the () as an arg of the () or Behavior as an arg
	}

	private static void filterAndPredicate(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream() // extaxt to method
			.filter(predicate)
			.forEach(System.out::println);
	}

}
