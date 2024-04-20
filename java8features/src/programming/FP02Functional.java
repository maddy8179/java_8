package programming;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		
		List<Integer> doubledNumbers = doubleList(numbers);
		System.out.println(doubledNumbers);
		
		System.out.println(numbers.stream().filter(number -> number%2 ==0).collect(Collectors.toList()));
		
		List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","pcp","Azure","Docker","Kubernatess");

		System.out.println(courses.stream().map(course -> course.length()).collect(Collectors.toList()));
		
//		int sum = addListFunctional(numbers);
//		System.out.println(sum);
	}
	
	private static List<Integer> doubleList(List<Integer> numbers) {
		return numbers.stream().map(number -> number*number).collect(Collectors.toList());
	}
	
	//aggregation operation
	private static int sum(int aggregate, int nextNumber) {
		System.out.println(aggregate + " " + nextNumber);
		return aggregate+nextNumber;
	}
	
	//reduce operation in traditional FP
	private static int addListFunctional(List<Integer> numbers) {
		
		//return numbers.stream().reduce(0, FP02Functional::sum);
		
		//aggregate function
		//return numbers.stream().reduce(0, (x,y) -> x+y);
		return numbers.stream().reduce(0, Integer::sum);
		
//		int sum =0;
//		for (Integer number : numbers) {
//			sum += number;
//		}	
//		return sum;
	}

	// the operations that are taking stream and returning back as stream called intermediate operations.
	//returning void or something otherthan stream back terminal operations forEach,collect,reduce
	//whenever we do something with a stream, we get the stream a no'of intermediate oper and then at the end
	//we do terminal oper to get the result from it
}
