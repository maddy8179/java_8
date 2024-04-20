package programming;

import java.util.List;

public class FP01Excercise2 {

	public static void main(String[] args) {
		List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","pcp","Azure","Docker","Kubernatess");
		
		//courses.stream().forEach(System.out::println);
		//printAll(courses);
		
		//courses.stream().filter(cours -> cours.contains("Spring")).forEach(System.out::println);
		//printSpring(courses);
		//printFourCharacters(courses);
		printNoofCharacters(courses);
	}
	
//	private static void print(String course) {
//		System.out.println(course);
//	}
	
//	private static void printAll(List<String> course) {
//		course.stream().forEach(System.out::println);
//	}
	private static void printSpring(List<String> course) {
		course.stream().filter(cours -> cours.contains("Spring")).forEach(System.out::println);
	}
	private static void printFourCharacters(List<String> course) {
		course.stream().filter(cours -> cours.length()>=3).forEach(System.out::println);
	}
	private static void printNoofCharacters(List<String> course) {
		course.stream().map(cours -> cours + " " + cours.length()).forEach(System.out::println);
	}
}
