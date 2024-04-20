package com.arjun.revision;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02Exercise2 {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(11,10,2,5,3,6,5,8,9,10);
		
//		System.out.println(numbers.stream().map(x -> x*x).reduce(0, Integer::sum));
//		System.out.println(numbers.stream().map(x -> x*x*x).reduce(0, (x,y) -> x+y));
//		System.out.println(numbers.stream().filter(x -> x%2==1).reduce(0, (x,y) -> x+y));
		
		//numbers.stream().distinct().forEach(System.out::println);
		//numbers.stream().sorted().forEach(System.out::println); // for sorting 
		//numbers.stream().distinct().sorted().forEach(System.out::println); //for distinct value sorting

		List<String> courses = List.of("Spring", "Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");
		
		//courses.stream().sorted().forEach(x -> System.out.println(x));
		
		//natural sort is default sort alphabetical order
		//courses.stream().sorted(Comparator.naturalOrder()).forEach(x -> System.out.println(x));
		
		//for reversing order
		//courses.stream().sorted(Comparator.reverseOrder()).forEach(x -> System.out.println(x));
		
		//for custom comparator
		//courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(x -> System.out.println(x));
		
		
		//Collecting stream elements to List using collect
		List<Integer> doubleNumbers = doubleList(numbers);
		System.out.println(doubleNumbers);
		
		System.out.println(numbers.stream().filter(x -> x%2==0 ).collect(Collectors.toList()));
		
		System.out.println(courses.stream().map(x -> x.length()).collect(Collectors.toList()));
		
		//those () will take stream as i/p return Stream o/p called intermediate operations  -->filter,map,distinct,sorted
		//terminal operations return different types  -->forEach,collect,reduce
		
	}

	private static List<Integer> doubleList(List<Integer> numbers) {
		// TODO Auto-generated method stub
		return numbers.stream().map( x->x*x).collect(Collectors.toList());
	}

}
