package com.arjun.googling;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class SampleCodingQuestions {

	public static void main(String[] args) {
		List<Integer> listOfIntegers = List.of(10,12,13,4,5,6,7,8,9,1,2,3,4,5,6);
		
		Map<Boolean, List<Integer>> evenNumbers = listOfIntegers.stream().collect(Collectors.partitioningBy(i -> i%2 ==0));
		System.out.println(evenNumbers);
		
		List<Integer> listOfIntegers1 = Arrays.asList(10,12,13,4,5,6,7,8,9,1,2,3,4,5,6);
		
		Map<Boolean, List<Integer>> oddEvenNumersMap = listOfIntegers1.stream().collect(Collectors.partitioningBy(i -> i%2==0));
	//	oddEvenNumbersPrint(oddEvenNumersMap);
		
		String inputString = "Enjoy Every minute you will not get another chance";
		System.out.println(inputStringPrint(inputString));
		
		List<String> frequencyOfElements = Arrays.asList("baby", "darling", "love", "caring","baby","darling");
		System.out.println(frequencyOfElementsPrint(frequencyOfElements));
		
		List<Double> decimalsInReverse = Arrays.asList(10.0,20.2,10.3,10.4,10.5,10.6,10.2);
		decimalsInReversePrint(decimalsInReverse);
		
		System.out.println(AddingSuffixAndPrefixPrint(frequencyOfElements));
		
		multiples(listOfIntegers1);
		
		System.out.println(maximum(listOfIntegers1));
		System.out.println(minimum(listOfIntegers1));
		
		int[] a = new int[] {4,2,7,1};
		int[] b = new int[] {8,3,9,5};
		int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
		System.out.println(Arrays.toString(c));
		
		threeMax(listOfIntegers1);
		threeMin(listOfIntegers1);
		
		System.out.println(sum(listOfIntegers1));
		
		int i =345678;
		System.out.println(sum11(i));
		
		System.out.println(secondLargestNumber(listOfIntegers1));
		
		System.out.println(increasingOrderByLength(frequencyOfElements));
		
		
		System.out.println(listOfIntegers.stream().reduce(0, (x,y)-> x+y));
		//System.out.println(listOfIntegers.stream().average());
		
	}

	private static void oddEvenNumbersPrint(Map<Boolean, List<Integer>> oddEvenNumersMap) {
		Set<Entry<Boolean, List<Integer>>> entrySet = oddEvenNumersMap.entrySet();
		for (Entry<Boolean, List<Integer>>  entry : entrySet) {
			System.out.println("------------------------");
			if (entry.getKey()) {
				System.out.println("Even numbers");
			} else {
				System.out.println("Odd numbers");
			}
			System.out.println("-------------------------");
			List<Integer> list = entry.getValue();
			for (int i : list) {
				System.out.println(i);
			}
		}
	}
	private static Map<Character, Long> inputStringPrint(String inputString) {
		return inputString.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}
	
	private static Map<String, Long> frequencyOfElementsPrint(List<String> frequency) {
		return frequency.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}
	
	private static void decimalsInReversePrint(List<Double> decimals){
		decimals.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}
	
	private static String AddingSuffixAndPrefixPrint(List<String> sf) {
		return sf.stream().collect(Collectors.joining(" ","[","]"));
	}
	
	private static void multiples(List<Integer> multiple) {
		multiple.stream().filter(m -> m%5==0).forEach(System.out::println);
	}
	
	private static Integer maximum(List<Integer> maxi) {
		return maxi.stream().max(Comparator.naturalOrder()).get();
		
	}
	private static Integer minimum(List<Integer> mini) {
		return mini.stream().min(Comparator.naturalOrder()).get();
	}
	
	private static int[] concArray(int[] arr, int[] arr2) {
		return IntStream.concat(Arrays.stream(arr), Arrays.stream(arr2)).sorted().toArray();
	}
	
//	private static List<Integer> concArray(List<Integer> numbers, int[] arr11, int[] arr22) {
//		return numbers.concat(Arrays.stream(arr11), Arrays.stream(arr22)).sorted().toArray();
//	}
	
	private static void threeMax(List<Integer> numbers){
		numbers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
	}
	
	private static void threeMin(List<Integer> numbers){
		numbers.stream().sorted().limit(3).forEach(System.out::println);
	}
	
	private static int sum(List<Integer> sum1) {
		return sum1.stream().reduce(0, Integer::sum);
	}
	
	private static int sum11(int i) {
		return Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));
	}
	
	private  static int secondLargestNumber (List<Integer> number) {
		return number.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
	}
	
	private static List<String> increasingOrderByLength(List<String> numbers) {
		 return numbers.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
	}
	
	
}
