package programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterface {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		
		
		// the type is not really necessary in RHS because it is automatically infered from LHS ex:Integer---Integer x
		Predicate<Integer> isEvenpredicate = x -> x%2==0;
		//internal working
		Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {

			@Override
			public boolean test(Integer x) {
				// TODO Auto-generated method stub
				return x%2==0;
			}
			
		};
		
		Function<Integer, Integer> squarefunction = x -> x*x;
		// a function used when you take a input and you return output back
		Function<Integer, Integer> squarefunction2 = new Function<Integer, Integer>() {
			
			@Override
			public Integer apply(Integer x) {
				// TODO Auto-generated method stub
				return x*x;
			}
		};
		
		Consumer<Integer> sysoutConsumer = System.out::println;
		Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {

			@Override
			public void accept(Integer x) {
				// TODO Auto-generated method stub
				System.out.println(x);
			}
			
		};
		
		numbers.stream().filter(isEvenPredicate2).map(squarefunction2).forEach(sysoutConsumer2);
		
		
		BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
		BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
			
			@Override
			//apply is the function descriptor because every FI has different abstract() but only one abstract ()
			public Integer apply(Integer a, Integer b) {
				// TODO Auto-generated method stub
				return a+b;
			}
		}; 
		
		
		int sum = numbers.stream().reduce(0, sumBinaryOperator);
		
	}

}
