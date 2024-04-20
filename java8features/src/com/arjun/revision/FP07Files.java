package com.arjun.revision;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FP07Files {

	public static void main(String[] args) throws IOException {
		Files.lines(Paths.get("File1.txt")).forEach(System.out::println);;
//		Some text
//		Some text that will be saved
//		A lot of text present in here

		Files.lines(Paths.get("File1.txt")).map(str -> str.split(" ")).flatMap(Arrays::stream).distinct().sorted().forEach(System.out::println);;
//		A
//		Some
//		be
//		here
//		in
//		lot
//		of
//		present
//		saved
//		text
//		that
//		will
		
		//for directories
		Files.list(Paths.get(".")).forEach(System.out::println);
		
		//for filtering directory
		Files.list(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);
		
		

	}

}
