package com.arjun.revision;

import java.util.List;

public class FP01Exercise1 {

	public static void main(String[] args) {
		List<String> courses = List.of("Spring", "Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");
		//printCourses(courses);
		//printContainSpring(courses);
		//printAtleastFour(courses);
		
		/*
		 * courses.stream() 
		 * .filter(x -> x.contains("Spring"))
		 * .forEach(System.out::println);
		 */
		
		//using map()
		courses.stream().map(x -> x + " " +x.length()).forEach(System.out::println);
	}
	
	private static void print(String courses) {
		System.out.println(courses);
	}
	private static void printCourses(List<String> courses) {
		courses.stream()
			//below all give same o/p
			//.forEach(FP01Exercise1::print);
			//.forEach(System.out::println);
			.forEach(x -> System.out.println(x));
	}
	private static void printContainSpring(List<String> course) {
		course.stream()
		.filter(x -> x.contains("Spring"))
		.forEach(System.out::println);
	}
	
	
	private static boolean isFourCharacters(String course) {
		return course.length()>=4;
	}
	private static void printAtleastFour(List<String> course) {
		course.stream().filter(FP01Exercise1::isFourCharacters).forEach(System.out::println);
	}

}
