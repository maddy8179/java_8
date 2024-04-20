package programming;

import java.util.List;
import java.util.function.Supplier;

public class FP03MethodRefrences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","pcp","Azure","Docker","Kubernatess");
		
		//forEach( x-> S.o.pln(x)); or forEach(System.out::println);sttic method provided by java is same
		//calling static method cutom designed
		courses.stream()
				//.map(x -> x.toUpperCase()) // objecct
				//we can non-static methods in the object by using method refrences
				.map(String::toUpperCase)
				.forEach(FP03MethodRefrences::print);
		//constructor refrence //for new objects //supplier.get() we will gwt new string back
		Supplier<String> supplier = String::new;
	}
	
	private static void print(String str) {
		System.out.println(str);
	}
}
