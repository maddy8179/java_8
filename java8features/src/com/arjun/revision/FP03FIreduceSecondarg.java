package com.arjun.revision;

import java.util.List;
import java.util.function.BinaryOperator;

public class FP03FIreduceSecondarg {
	
	//Binary Operator
//find FI behind that the second arg of reduce() . create an implementation for the FI.
	// int sum = numers.stream().reduce(0, Integer::sum);
	public static void main(String[] args) {
		List<Integer> numbers = List.of(11,10,2,5,3,6,8,9,10);

		//Operator that all the i/p and o/p are same type
		BinaryOperator<Integer> accumulator = Integer::sum;// BO - BIFunction apply() -function 
		BinaryOperator<Integer> accumulator1 = (x,y) -> x+y;//above is same like this
											//it is the representation of below  class
		BinaryOperator<Integer> accumulator2 = new BinaryOperator<Integer>() {// ananymous class
			
			@Override
			public Integer apply(Integer a, Integer b) {
				// TODO Auto-generated method stub
				return a +b;
			}
		};
		
		
		int sum = numbers.stream().reduce(0, accumulator);
		
		//Behavior Parameterization with FI
		
		
	}

}
