package com.arjun.revision;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterface {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(11,10,2,5,3,6,5,8,9,10);
		
//		//previously we done like this
//		numbers.stream()
//			//internal working of filter LE
//			/*
//			 * boolean isEven(int x){
//			 * return x%2 ==0;
//			 * }
//			 */
//			.filter(x -> x%2==0)
//			//internal working of map LE
//			/*
//			 * int squared(int x){
//			 * return x*x;
//			 * }
//			 */
//			.map( x -> x*x)
//			//method refrence is a simplified version of Lambda
//			.forEach(System.out::println);
//			
		
			//When we are creating LE an instance of Predicate class was created
			//FI is having only one abstract ()this is called as function descriptor and other methods may either default or static
			Predicate<Integer> isEvenPredicate = x-> x%2==0; //test()
			//internally it is happening this specific logic is created 
			//Backword compatability --> new v is coming it did not want to break any existing code which was present
			//LE is represented almost like object because objects are first class citizens in java
			Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
				
				@Override
				public boolean test(Integer x) {
					// TODO Auto-generated method stub
					return x%2==0;
				}
			};
			
			Function<Integer,Integer> squarefunction = x -> x*x;//x -> x*x it is Behavior of the specific () and putting into variable
																//can we use this and pass as an arg to another () -->Behavior Parameterization
			//take i/p value and return o/p back
			Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {
				
				@Override
				public Integer apply(Integer x) {
					// TODO Auto-generated method stub
					return x*x;
				}
			};
			Function<Integer, String> stringOpFuncton = x -> x+" "; 
			
			Consumer<Integer> sysOutConsumer = System.out::println;
			//it takes i/p arg and retuns no result back
			Consumer<Integer> sysOutConsumer2 = new Consumer<Integer>() {
				
				@Override
				public void accept(Integer x) {
					System.out.println(x);
				}
			};
			numbers.stream().filter(isEvenPredicate2).map(squareFunction2).forEach(sysOutConsumer2);;
	}

}
