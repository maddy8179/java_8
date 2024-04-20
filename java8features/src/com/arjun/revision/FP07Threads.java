package com.arjun.revision;

import java.util.Iterator;
import java.util.stream.IntStream;

public class FP07Threads {

	public static void main(String[] args) {
		
		//structured approach
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(Thread.currentThread().getId() + ":" + i);
					
				}
			}
		};
		
		//functional approach
		//Runnable also FI because only one abstract() is run
		Runnable runnable2 = () -> {
		
				for (int i = 0; i < 100; i++) {
					System.out.println(Thread.currentThread().getId() + ":" + i);
			}
		};
		//eliminate the loop
		Runnable runnable3 = () -> {
			
			IntStream.range(0, 1000).forEach(
				i -> System.out.println(Thread.currentThread().getId() + ":" + i));
				};
		
		Thread thread = new Thread(runnable2);
		thread.start();
		
		Thread thread2 = new Thread(runnable2);
		thread2.start();
		
		Thread thread3 = new Thread(runnable2);
		thread3.start();
	}

}
