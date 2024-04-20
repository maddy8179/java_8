package com.arjun.revision;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class Course{
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;

	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public String toString() {
		return name + ":" + noOfStudents + ":" + reviewScore;
	}

}

public class FP04CustomClass {

	public static void main(String[] args) {
		List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000), 
				new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000), 
				new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000), 
				new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000));
		
		//utility methods
		//allMatch return boolean
		Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore()>95;
		System.out.println(
		courses.stream()
			.allMatch(reviewScoreGreaterThan95Predicate)
			);
		
		//noneMatch() return boolean
		Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore()>90;
		Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore()<90;

		System.out.println(
				courses.stream()
					.noneMatch(reviewScoreLessThan90Predicate)
					);
		System.out.println(
				courses.stream()
					.anyMatch(reviewScoreGreaterThan95Predicate)
					);
		
		//sorting and creating comparators
		Comparator comparingBynoOfStudentsIncreasing = Comparator.comparingInt(Course::getNoOfStudents);
		//System.out.println(courses.stream().sorted(Comparator.comparingInt(Course::getNoOfStudents)).collect(Collectors.toList()));
		System.out.println(courses.stream().sorted(comparingBynoOfStudentsIncreasing).collect(Collectors.toList()));
		//[FullStack:14000:91, Spring Boot:18000:95, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, AWS:21000:92, Azure:21000:99, API:22000:97, Microservices:25000:96]

		
		Comparator<Course> comparingBynoOfStudentsDecreasing = Comparator.comparingInt(Course::getNoOfStudents).reversed();
		System.out.println(courses.stream().sorted(comparingBynoOfStudentsDecreasing).collect(Collectors.toList()));
		//[Microservices:25000:96, API:22000:97, AWS:21000:92, Azure:21000:99, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]

		
		Comparator comparingBynoOfStudentsAndNoofReviews = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed();
		System.out.println(courses.stream().sorted(comparingBynoOfStudentsAndNoofReviews).collect(Collectors.toList()));
		//[Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]

		//above all get()'s are primitives that's we use comparingInt()instead of comparing()
		
		//skip,limit,takeWhile,dropWhile
		//for limiting top 5 values
		System.out.println(courses.stream().sorted(comparingBynoOfStudentsAndNoofReviews).limit(5).collect(Collectors.toList()));
		//[Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98]
		
		//for skipping top 3 lisis
		System.out.println(courses.stream().sorted(comparingBynoOfStudentsAndNoofReviews).skip(3).collect(Collectors.toList()));
		//[AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]

		//for skip 3and get rest of list
		System.out.println(courses.stream().sorted(comparingBynoOfStudentsAndNoofReviews).skip(3).limit(5).collect(Collectors.toList()));
		//[AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95]

		System.out.println(courses);
		//[Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96, FullStack:14000:91, AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91]
		
		//all courses until >=95 after that will not print(one element not meets the criteria after that it will skip)
		System.out.println(courses.stream().takeWhile(course -> course.getReviewScore()>=95).collect(Collectors.toList()));
		//[Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96]

		//dropWhile opposite the above ()
		System.out.println(courses.stream().dropWhile(course -> course.getReviewScore()>=95).collect(Collectors.toList()));
		//[FullStack:14000:91, AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91]

		/*
		 * finding top, max & min courses with max,min,findFirst and findAny
		 */
		
		//max will sort the the list and return the last element of the list it doesn't know max or min
		System.out.println(courses.stream().max(comparingBynoOfStudentsAndNoofReviews));
		//Optional[FullStack:14000:91]

		//min it will return first element in the list
		System.out.println(courses.stream().min(comparingBynoOfStudentsAndNoofReviews));
		//Optional[Microservices:25000:96]
		
		System.out.println(courses.stream().filter(reviewScoreLessThan90Predicate).min(comparingBynoOfStudentsAndNoofReviews));
		//Optional.empty
		
		// instead of null return back we use Optional it will allow to specify a default value
		// it didn't find any value return  orElse value
		System.out.println(courses.stream().filter(reviewScoreLessThan90Predicate).min(comparingBynoOfStudentsAndNoofReviews).orElse(new Course("Kubernetes", "Cloud", 91, 20000)));
		//Kubernetes:20000:91
		System.out.println(courses.stream().min(comparingBynoOfStudentsAndNoofReviews).orElse(new Course("Kubernetes", "Cloud", 91, 20000)));
		//Microservices:25000:96
	
		System.out.println(courses.stream().filter(reviewScoreLessThan90Predicate).findFirst());
		//Optional.empty
		System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate).findFirst());
		//Optional[Spring:20000:98]

		//it will return one of the value which meets the criteria
		System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate).findAny());
		//Optional[Spring:20000:98]
		
		
		/*single result back operations
		 *sum, average, count
		 */
		System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNoOfStudents).sum());
		//88000
		
		System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNoOfStudents).average());
		//OptionalDouble[22000.0]

		System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNoOfStudents).count());
		//4
		
		System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNoOfStudents).max());
		//OptionalInt[25000]
		
		/*
		 * Grouping courses into map using groupingBy()
		 */
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory)));
		//{Cloud=[AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91], FullStack=[FullStack:14000:91], Microservices=[API:22000:97, Microservices:25000:96], Framework=[Spring:20000:98, Spring Boot:18000:95]}

		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
		//{Cloud=4, FullStack=1, Microservices=2, Framework=2}

		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
		//{Cloud=Optional[Azure:21000:99], FullStack=Optional[FullStack:14000:91], Microservices=Optional[API:22000:97], Framework=Optional[Spring:20000:98]}

		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList()))));
		//{Cloud=[AWS, Azure, Docker, Kubernetes], FullStack=[FullStack], Microservices=[API, Microservices], Framework=[Spring, Spring Boot]}
		
		
		
		/*
		 * creating streams using stream of method and for arrays
		 * 
		 */
		//both same
		//above numbers List and this Stream are same hold instances of Wrapper classes(Refrencepipelines) //boxing and unboxing each time will happen
		System.out.println(courses.stream());//java.util.stream.ReferencePipeline$Head@15327b79
		//for creating streams directly
		System.out.println(Stream.of(10,3,4,5,7,8,9,11,13));//java.util.stream.ReferencePipeline$Head@15327b79
		System.out.println(Stream.of(10,3,4,5,7,8,9,11,13).count());
		System.out.println(Stream.of(10,3,4,5,7,8,9,11,13).reduce(0, Integer::sum));
	
		//streams with primitive values
		int[] numberArray = {10,3,4,5,7,8,9,11,13};
		System.out.println(Arrays.stream(numberArray));//java.util.stream.IntPipeline$Head@78e03bb5
		//primitive we can do no'of operations directly
		System.out.println(Arrays.stream(numberArray).sum());//70
		System.out.println(Arrays.stream(numberArray).average());//OptionalDouble[7.777777777777778]
		System.out.println(Arrays.stream(numberArray).min());//OptionalInt[3]
		System.out.println(Arrays.stream(numberArray).max());//OptionalInt[13]

		/*
		 * creating streams for 1st 100 numbers,squares of numbers and more
		 */
		//we can create primitive stream with IntStream
		System.out.println(IntStream.range(1, 10));//java.util.stream.IntPipeline$Head@50134894
		System.out.println(IntStream.range(1, 10).sum());//45 it excludes last number means 1-9
		System.out.println(IntStream.rangeClosed(1, 10).sum());//55 for  including 10th number
		//without sequential numbers
		System.out.println(IntStream.iterate(1, e -> e+2).limit(10).sum());//iterate(1, e -> e+2)this is an infinite stream for limit we use limit()
		//for printing all values in stream peek()
		System.out.println(IntStream.iterate(1, e -> e+2).limit(10).peek(System.out::println).sum());		
		//1 
		//3
//		5
//		7
//		9
//		11
//		13
//		15
//		17
//		19
//		100//it is sum of all elements
		//for even numbers
		System.out.println(IntStream.iterate(2, e -> e+2).limit(10).peek(System.out::println).sum());		
//		2
//		4
//		6
//		8
//		10
//		12
//		14
//		16
//		18
//		20 /it is sum of all elements
		//for printing square numbers
		System.out.println(IntStream.iterate(2, e -> e*2).limit(10).peek(System.out::println).sum());	
		//to convert primitive stream into list
		//System.out.println(IntStream.iterate(2, e -> e*2).limit(10).collect(Collectors.toList()));//CTE	
		System.out.println(IntStream.iterate(2, e -> e*2).limit(10).boxed().collect(Collectors.toList()));
		//[2, 4, 8, 16, 32, 64, 128, 256, 512, 1024]

		/*
		 * Doing Big number calculations with BigInteger
		 */
		System.out.println(Integer.MAX_VALUE);// upto this limit we can do
		System.out.println(Long.MAX_VALUE);
		
		System.out.println(IntStream.rangeClosed(1, 50).reduce(1, (x,y)->x*y));//0
		System.out.println(LongStream.rangeClosed(1, 50).reduce(1, (x,y)->x*y));//-3258495067890909184
		System.out.println(LongStream.rangeClosed(1L, 50).reduce(1, (x,y)->x*y));//-3258495067890909184
		
		System.out.println(LongStream.rangeClosed(1, 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));

	
		

		
		/*
		 * creating higher order functions
		 */
		//HOF is a function which return a function
		
		Predicate<Course> reviewScoreGreaterThan95Predicate2 = createPredicateWithCutoffReviewScore(95);
		
		Predicate<Course> reviewScoreGreaterThan90Predicate2 = createPredicateWithCutoffReviewScore(90);

		
		
	}
	//below () is called Higher Order function return another function as return value
	private static Predicate<Course> createPredicateWithCutoffReviewScore(int cutOffReviewScore) {
		return course -> course.getReviewScore()>cutOffReviewScore;
	}
	
}
