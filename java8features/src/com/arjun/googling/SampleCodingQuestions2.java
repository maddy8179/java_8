package com.arjun.googling;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SampleCodingQuestions2 {

	public static void main(String[] args) {
		
		List<Integer> list1 = Arrays.asList(71,21,34,89,56,28);
		List<Integer> list2 = Arrays.asList(12,56,17,21,94,34);
		
		commonElements(list1, list2);
		
		List<String> frequencyOfElements = Arrays.asList("baby", "darling", "love", "caring","baby","darling");
		
		System.out.println(IntStream.rangeClosed(1, 10).sum());
		
		int[] array = new int[] {71,21,34,89,56,28};
		int[] reverseArray = IntStream.rangeClosed(1, array.length).map(i -> array[array.length - i]).toArray();
		System.out.println(Arrays.toString(reverseArray));

	}
	
	private static void commonElements(List<Integer> a, List<Integer> b) {
		a.stream().filter(b::contains).forEach(System.out::println);
	}
	
	private static String reverseString(String list) {
		return Arrays.stream(list.split(" ")).map(word -> new StringBuffer(word).reverse()).collect(Collectors.joining(" "));
	}
	

}
