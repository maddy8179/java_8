package programming;

import java.nio.file.DirectoryStream.Filter;
import java.util.List;
import java.util.stream.Collectors;

public class FP01Functional {

	public static void main(String[] args) {
		List<Integer> numbers =List.of(12,9,13,4,6,2,4,12,15);
		
		//printAllNumbersInListFunctional(List.of(12,9,13,4,6,2,4,12,15));
		//printEvenNumbersInListFunctional(numbers);
		printEvenSquareNumbersInListFunctional(numbers);
	}
	
//	private static void print(int number) {
//		System.out.println(number);
//	}
	private static boolean isEven(int number) {
		return number%2==0;
	}

	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
//		numbers.stream().forEach(FP01Functional::print);
		// instead of creating new method we use sys in System.out we have a static method println
		numbers.stream().forEach(System.out::println);
		
		
//		for (Integer number : numbers) {
//			System.out.println(number);
//		}
		
	}
	
	private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
//		numbers.stream().filter(FP01Functional::isEven).forEach(System.out::println);
		numbers.stream().filter(number -> number%2==0).forEach(System.out::println);
	}
	
	private static void printEvenSquareNumbersInListFunctional(List<Integer> numbers) {
//		numbers.stream().filter(FP01Functional::isEven).forEach(System.out::println);
		numbers.stream().filter(number -> number%2==0).map(number -> number * number).forEach(System.out::println);
	}
}
