package com.arjun.revision;

import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(11,10,2,5,3,6,8,9,10);
		
		//printNumbers(numbers);
		
		//printEven(numbers);
		//FP01Functional.printOdd(numbers);
		
		
		//Using map()
		//numbers.stream().filter(x -> x%2==0).map(x -> x*x).forEach(System.out::println);
		numbers.stream().filter(x -> x%2==1).map(x -> x*x*x).forEach(x -> System.out.println(x));
		
	}
	
	//() with parameter
	private static void print(int numbers) {
		System.out.println(numbers);
	}
	private static void printNumbers(List<Integer> numbers) {
		//numbers.stream().forEach(x -> System.out.println(x));
		//[11,10,2,5,3,6,8,9,10] we are converting list into stream of elements 
		//11 //10 //2 //2 like this
		numbers.stream()
			//for each element we need to print for that we used method refrence we are calling print() which is in present class.
			.forEach(FP01Functional::print); //method refrence
		//numbers.stream().forEach(System.out::println);
	}
	
	private static boolean isEven(int numbers) {
		return numbers%2==0;
	}
	private static void printEven(List<Integer> numbers) {
		numbers.stream()
			//.filter(FP01Functional::isEven) // filter -only allow even numbers
			//LE is nothing but a () ====> isEven() has numbers has parameter and check the even//number -> number%2==0
			// by default LE if you just have one statement present, it will return that value back.
			.filter(x -> x%2==0) //LE
			.forEach(System.out::println);
	}
	
	private static boolean isOdd(int numbers) {
		return numbers%2==1;
	}
	private static void printOdd(List<Integer> numbers) {
		numbers.stream()
			//with defined()
			//.filter(FP01Functional::isOdd)
			.filter(x -> x%2==1)
			.forEach(System.out::println);
	}

}
