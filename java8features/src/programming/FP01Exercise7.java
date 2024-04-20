package programming;

import java.util.List;

public class FP01Exercise7 {
	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		
		//System.out.println(numbers.stream().map(number -> number*number).reduce(0, (x,y) -> x+y));
		System.out.println(sum(numbers));
	}
	
	private static int sum(List<Integer> numbers) {
		return numbers.stream().map(number -> number*number).reduce(0, (x,y) -> x+y);
	}

}
