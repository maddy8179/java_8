package com.arjun.revision;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP03FI2 {
	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(11,10,2,5,3,6,5,8,9,10);

		Predicate<Integer> isEvenPredicate = x -> x%2==0;//test()
		
		Function<Integer, Integer> squareFunction = x -> x*x;//apply()
		
		Consumer<Integer> sysoutConsumer =  x -> System.out.println(x);//accept()
		
		BinaryOperator<Integer> sumBinaryOperator = (x,y) -> x+y;
		
		
		//No input ->return o/p like factory pattern  2 parameters of same type and return same type
		//it will automatically return value integer below
		Supplier<Integer> randomIntegerSupplier = () -> 2;//get()
		//for multiple lines of code we need mention explicitly
		Supplier<Integer> randomIntegerSupplier2 = () -> {
			Random random =new Random();
			return random.nextInt(1000);
			
			//return 2;
		};
		System.out.println(randomIntegerSupplier2.get());
		
		
		//UO it will take one parameter and return same type as the o/p
		UnaryOperator<Integer> unaryOperator = (x) -> 3*x;
		System.out.println(unaryOperator.apply(10));
		
		///Bi
		//there should be two i/p and the o/p type boolean
		BiPredicate<Integer, String> biPredicate = (number, str) -> true;
		BiPredicate<Integer, String> biPredicate2 = (number, str) -> {
			return number<10 && str.length()>5;
			
		};
		System.out.println(biPredicate2.test(5, "arjunreddy"));
		
		BiFunction<Integer,String , String> biFunction = (number, str) -> {
			return number + "  " + str;
			
		};
		System.out.println(biFunction.apply(5, "arjunreddy"));
		
		BiConsumer<Integer, String> biConsumer = (s1,s2) -> {
			System.out.println(s1);
			System.out.println(s2);
		};
		biConsumer.accept(25, "arjunreddy");
		
		//above all accepts wrapper class objects as parameter in this boxing and un-boxing comes into picture it is inefficient
		
		//below all are primitive operations no b&u-b
		//Consumer<String> consumer =() -> {}; CTE
		Consumer<String> consumer =(str) -> {};
		Consumer<String> consumer2 =System.out::println;
		Consumer<String> consumer3 = (str) -> System.out.println(str);;
		System.out.println(consumer);
		
		BiConsumer<String, String> biConsumer1 = (str, str1) -> System.out.println(str);
		Supplier<String> supplier1 = () -> "Arjun";
		//Supplier<String> supplier1 = () -> {"Arjun"}; CTE
		Supplier<String> supplier2 = () -> {
			return "Arjun";
		};
		//Consumer<String> consumer4 = (str) -> System.out.println(str);System.out.println(str);CTE
		Consumer<String> consumer4 = (str) -> {
			System.out.println(str);
			System.out.println(str);
		};

		System.out.println(biConsumer1);
		
		//above all we didn't provided type for LE
		
		//type inference it is not necessary it will automatically inferred from LHS
		Predicate<Integer> isEvenPredicate1 = (Integer x) -> x%2==0;
		//in case we provided to one parameter we need to provide type to another parameter
		BinaryOperator<Integer> sumBinaryOperator1 = (Integer x,Integer y) -> x+y;
	}

}
