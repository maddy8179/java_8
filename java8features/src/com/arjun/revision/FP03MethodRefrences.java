package com.arjun.revision;

import java.util.List;
import java.util.function.Supplier;

public class FP03MethodRefrences {

	public static void main(String[] args) {
		List<String> courses = List.of("Spring", "Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");
		
		courses.stream()
			//.map(x -> x.toUpperCase())//we can use MR to call things on a specific object
			.map(String::toUpperCase)//non-static ()or instance () also we can use//we are calling () which is on the obj
			//.forEach((str) -> System.out.println(str)); LE
			//.forEach(System.out::println);
			.forEach(FP03MethodRefrences::print); //by uxing custom class static ()
		
		//constructor refrence
		//we can also replace a call to a constructor with a constructor refrence //new is CR
		Supplier<String> supplier = () -> new String();
		Supplier<String> supplier1 = String::new;
	}
	
	private static void print(String str) {
		System.out.println(str);
	}

}
