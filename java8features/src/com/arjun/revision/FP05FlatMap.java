package com.arjun.revision;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FP05FlatMap {

	public static void main(String[] args) {
		List<String> courses = List.of("Spring", "Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");

		/*
		 * Joining strings with joining and playing flatmap
		 */
		//combine all of them separated by,
		System.out.println(courses.stream().collect(Collectors.joining(" ")));//with space
		//Spring Spring Boot API Microservices AWS PCF Azure Docker Kubernetes
		
		System.out.println(courses.stream().collect(Collectors.joining(",")));//for comma separator
		//Spring,Spring Boot,API,Microservices,AWS,PCF,Azure,Docker,Kubernetes

		//for printing all characters in each one of the strings
		System.out.println("Spring".split(""));
		//o/p in jshell String[6] { "S", "p", "r", "i", "n", "g" }
		
		//it didn't work as expected because course -> course.split("") this will give string array
		//the result of entire map is stream of string arrays
		System.out.println(courses.stream().map(course -> course.split("")).collect(Collectors.toList()));
		//[[Ljava.lang.String;@76fb509a, [Ljava.lang.String;@300ffa5d, [Ljava.lang.String;@1f17ae12, [Ljava.lang.String;@4d405ef7, [Ljava.lang.String;@6193b845, [Ljava.lang.String;@2e817b38, [Ljava.lang.String;@c4437c4, [Ljava.lang.String;@433c675d, [Ljava.lang.String;@3f91beef]

		//we need stream of characters
		System.out.println(courses.stream().map(course -> course.split("")));
		//java.util.stream.ReferencePipeline$3@37bba400
		//Stream of String[] => Stream of Strings
		//Stream[["S","p","r","i","n","g"],["A","W","S"],.......] => Stream["S","p","r","i","n","g","A","W","S",............]
		//for above this one we go for flatmap(stream of string arrays into stream of string)
		//flatMap(): each element of Stream replaced with content of mapped stream (Arrays::stream)
		//["S","p","r","i","n","g"] => "S","p","r","i","n","g"
		//["A","W","S"] => "A","W","S"
		System.out.println(courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).collect(Collectors.toList()));
		//[S, p, r, i, n, g, S, p, r, i, n, g,  , B, o, o, t, A, P, I, M, i, c, r, o, s, e, r, v, i, c, e, s, A, W, S, P, C, F, A, z, u, r, e, D, o, c, k, e, r, K, u, b, e, r, n, e, t, e, s]

		System.out.println(courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()));
		//[S, p, r, i, n, g,  , B, o, t, A, P, I, M, c, s, e, v, W, C, F, z, u, D, k, K, b]

		//flatMap usecases
		//Expected o/p -Tuple with same Length [[Spring,Docker],[API,AWS],[API,PCF],[AWS,API],[AWS,PCF],[PCF,API],[PCF,AWS],[Docker,Spring]]
	
		List<String> courses2 = List.of("Spring", "Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");
		
		//taking each of course in the list and trying to map with each of the course in the specific list
		System.out.println(courses2.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(course,course2))).collect(Collectors.toList()));
		//[[Spring, Spring], [Spring, Spring Boot], [Spring, API], [Spring, Microservices], [Spring, AWS], [Spring, PCF], [Spring, Azure], [Spring, Docker], [Spring, Kubernetes], [Spring Boot, Spring], [Spring Boot, Spring Boot], [Spring Boot, API], [Spring Boot, Microservices], [Spring Boot, AWS], [Spring Boot, PCF], [Spring Boot, Azure], [Spring Boot, Docker], [Spring Boot, Kubernetes], [API, Spring], [API, Spring Boot], [API, API], [API, Microservices], [API, AWS], [API, PCF], [API, Azure], [API, Docker], [API, Kubernetes], [Microservices, Spring], [Microservices, Spring Boot], [Microservices, API], [Microservices, Microservices], [Microservices, AWS], [Microservices, PCF], [Microservices, Azure], [Microservices, Docker], [Microservices, Kubernetes], [AWS, Spring], [AWS, Spring Boot], [AWS, API], [AWS, Microservices], [AWS, AWS], [AWS, PCF], [AWS, Azure], [AWS, Docker], [AWS, Kubernetes], [PCF, Spring], [PCF, Spring Boot], [PCF, API], [PCF, Microservices], [PCF, AWS], [PCF, PCF], [PCF, Azure], [PCF, Docker], [PCF, Kubernetes], [Azure, Spring], [Azure, Spring Boot], [Azure, API], [Azure, Microservices], [Azure, AWS], [Azure, PCF], [Azure, Azure], [Azure, Docker], [Azure, Kubernetes], [Docker, Spring], [Docker, Spring Boot], [Docker, API], [Docker, Microservices], [Docker, AWS], [Docker, PCF], [Docker, Azure], [Docker, Docker], [Docker, Kubernetes], [Kubernetes, Spring], [Kubernetes, Spring Boot], [Kubernetes, API], [Kubernetes, Microservices], [Kubernetes, AWS], [Kubernetes, PCF], [Kubernetes, Azure], [Kubernetes, Docker], [Kubernetes, Kubernetes]]

		//eliminate same elements repeated twice [[Spring,Spring],[Spring Boot, Spring Boot].........]
		System.out.println(courses2.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(course,course2))).filter(list -> list.get(0).equals(list.get(1))).collect(Collectors.toList()));
		//[[Spring, Spring], [Spring Boot, Spring Boot], [API, API], [Microservices, Microservices], [AWS, AWS], [PCF, PCF], [Azure, Azure], [Docker, Docker], [Kubernetes, Kubernetes]]

		//we don't need above for this use !
		System.out.println(courses2.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(course,course2))).filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList()));
		//[[Spring, Spring Boot], [Spring, API], [Spring, Microservices], [Spring, AWS], [Spring, PCF], [Spring, Azure], [Spring, Docker], [Spring, Kubernetes], [Spring Boot, Spring], [Spring Boot, API], [Spring Boot, Microservices], [Spring Boot, AWS], [Spring Boot, PCF], [Spring Boot, Azure], [Spring Boot, Docker], [Spring Boot, Kubernetes], [API, Spring], [API, Spring Boot], [API, Microservices], [API, AWS], [API, PCF], [API, Azure], [API, Docker], [API, Kubernetes], [Microservices, Spring], [Microservices, Spring Boot], [Microservices, API], [Microservices, AWS], [Microservices, PCF], [Microservices, Azure], [Microservices, Docker], [Microservices, Kubernetes], [AWS, Spring], [AWS, Spring Boot], [AWS, API], [AWS, Microservices], [AWS, PCF], [AWS, Azure], [AWS, Docker], [AWS, Kubernetes], [PCF, Spring], [PCF, Spring Boot], [PCF, API], [PCF, Microservices], [PCF, AWS], [PCF, Azure], [PCF, Docker], [PCF, Kubernetes], [Azure, Spring], [Azure, Spring Boot], [Azure, API], [Azure, Microservices], [Azure, AWS], [Azure, PCF], [Azure, Docker], [Azure, Kubernetes], [Docker, Spring], [Docker, Spring Boot], [Docker, API], [Docker, Microservices], [Docker, AWS], [Docker, PCF], [Docker, Azure], [Docker, Kubernetes], [Kubernetes, Spring], [Kubernetes, Spring Boot], [Kubernetes, API], [Kubernetes, Microservices], [Kubernetes, AWS], [Kubernetes, PCF], [Kubernetes, Azure], [Kubernetes, Docker]]

		//Filter tuple with same length [[Spring,Docker],[API,AWS]............]
		System.out.println(courses2.stream().flatMap(course -> courses2.stream().filter(course2 -> course2.length() == course.length()).map(course2 -> List.of(course,course2))).filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList()));
		// [[Spring, Docker], [API, AWS], [API, PCF], [AWS, API], [AWS, PCF], [PCF, API], [PCF, AWS], [Docker, Spring]]

		
		
		/*
		 * creating higher order functions
		 */
		//HOF is a function which return a function
		
		
		
		
		/*
		 * FP and Performance -Intermediate Stream Operations areLazy
		 */
		List<String> courses3 = List.of("Spring", "Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");

		System.out.println(courses3.stream().filter(course -> course.length()>11).map(String::toUpperCase).findFirst());
		//Optional[MICROSERVICES]
		System.out.println(courses3.stream().peek(System.out::println).filter(course -> course.length()>11).map(String::toUpperCase).peek(System.out::println).findFirst());
//		Spring
//		Spring Boot
//		API
//		Microservices
//		MICROSERVICES
//		Optional[MICROSERVICES]
		//findFirst() it starts looking one element at a time and it finds the element it will do toUpperCase
		// all intermediate operations in java is that all lazy (filter,map,peek) so they are not really executed when I am executing the code 
		//They are only executed the terminal operation (findFirst()) 
		//when you are defining intermediate operations nothing would be executed and we will o/p only when use terminal operations
		System.out.println(courses3.stream().peek(System.out::println).filter(course -> course.length()>11).map(String::toUpperCase).peek(System.out::println));
		
		
		
	}

}
