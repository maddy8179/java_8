package programming;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP03FunctionalInterface2 
{
	public static void main(String[] args) {
		
		//no input (we don't have sny parameters as input) > return something back ex:Factory pattern
		Supplier<Integer> randomIntegerSupplier = () -> {
			Random random = new Random();
			return random.nextInt(1000);
		};
		System.out.println(randomIntegerSupplier.get());
		
		//UO it will take one parameter as the input and returns result as the same type as the output
		UnaryOperator<Integer> unaryOperator = (x) -> 3*x;
		System.out.println(unaryOperator.apply(10));
		
		//BiPredicate two inputes and return o/p is boolean
		BiPredicate<Integer, String> biPredicate = (number,str) -> {
			return number<10 && str.length()>5;
		};
		System.out.println(biPredicate.test(5, "Abhimanyu"));
	
		BiFunction<Integer, String, String> biFunction = (number,str) -> {
			return number + " " + str;
		};
		System.out.println(biFunction.apply(15, "Abhimanyu"));
		
		BiConsumer<String, String> biConsumer = (s1,s2) -> {
			System.out.println(s1);
			System.out.println(s2);
		};
		biConsumer.accept("arjun", "Abhimanyu");
		
		//all are wrapper objects
		//wrapper type parameter boxing and unboxing comes it is inefficient
		BinaryOperator<Integer> sumBinaryOperator2 =(x,y) -> x+y;
		
		//primitive
		IntBinaryOperator intBinaryOperator = (x,y) -> x+y;
	}

}
