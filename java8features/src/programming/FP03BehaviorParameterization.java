package programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviorParameterization {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		
		/*
		 * //numbers.stream().filter(evenPredicate).forEach(System.out::println);
		 * filterAndPrint(numbers,x -> x%2 ==0); //passing logic(code) of method as an
		 * argument of the method is called BehaviorParameterization
		 * filterAndPrint(numbers,x -> x%2!=0);
		 */
		
		System.out.println(squareAndPrint(numbers, x -> x*x));
		
	}
	//functions have a first class status in java
	private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream().filter(predicate).forEach(x -> System.out.println(x));
	}
	
	private static List<Integer> squareAndPrint(List<Integer> numbers,Function<Integer, Integer> function) {
		return numbers.stream().map(function).collect(Collectors.toList());
	}

}
