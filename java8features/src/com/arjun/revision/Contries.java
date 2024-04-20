package com.arjun.revision;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Contries {

	public static void main(String[] args) {
		List<Integer> list = List.of(1,10,20,3,4,5,6);
		
		System.out.println(list.stream().map(x -> x*x*x).collect(Collectors.toList()));
		
		
		
		//write a program java 8 in 
		
		
	}

}
