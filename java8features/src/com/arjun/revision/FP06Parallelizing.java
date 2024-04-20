package com.arjun.revision;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class FP06Parallelizing {

	public static void main(String[] args) {

		/*
		 * Improving performance with parallelization ofStreams
		 */
		//now all laptops are multicore for using that we FP in parallel
		
		long time = System.currentTimeMillis();
		//0, 1000000000
		System.out.println(LongStream.range(0, 1000000000).sum());//499999999500000000
		System.out.println(System.currentTimeMillis() -time);//2771
		
		//for doing above one parallel
		long time1 = System.currentTimeMillis();
		System.out.println(LongStream.range(0, 1000000000).parallel().sum());//499999999500000000
		System.out.println(System.currentTimeMillis() -time1);//66
		//parallelize functional code is easy and why can't i just parallelize structured code?
		//because lot of state present
		
		
		/*
		 * Modifying lists with replaceAll(it takes function as parameter) and removeIf
		 */
		List<String> courses = List.of("Spring", "Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");

		//Immutable collections because whatever collection that created with List.of is a immutable collection
		//System.out.println(courses.replaceAll( str -> str.toUpperCase())); CTE
	
		List<String> modifyableCourses = new ArrayList<String>(courses);
		
		modifyableCourses.replaceAll( str -> str.toUpperCase());
		System.out.println(modifyableCourses);
		//[SPRING, SPRING BOOT, API, MICROSERVICES, AWS, PCF, AZURE, DOCKER, KUBERNETES]

		System.out.println(modifyableCourses.removeIf(course -> course.length()<6)); //true
		System.out.println(modifyableCourses);
		//[SPRING, SPRING BOOT, MICROSERVICES, DOCKER, KUBERNETES]
		
		
		/*
		 * Playing with Files using FP
		 */
		
		
		
	}

}
