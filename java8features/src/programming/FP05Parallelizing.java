package programming;

import java.util.stream.LongStream;

public class FP05Parallelizing {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		System.out.println(
				//for single core
		//LongStream.range(0, 1000000000).sum()
		//for multicore performance
				LongStream.range(0, 1000000000).parallel().sum()

				);
		System.out.println(System.currentTimeMillis() -time);
	}

}
