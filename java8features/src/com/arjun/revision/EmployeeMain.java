package com.arjun.revision;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeMain {

	public static void main(String[] args) {
		List<Employee> employeeList = List.of(new Employee(101, "aditya", "java", 50000.00),
				new Employee(102, "malreddy", "java7", 60000.00),
				new Employee(103, "nagaraju", "java8", 70000.00),
				new Employee(104, "arjun", "java7", 70000.00),
				new Employee(105, "reddy", "java", 70000.00),
				new Employee(106, "babu", "java8", 90000.00)
				);
		
		//Map<Integer, Optional<Employee>> maxSalaryFromEachDept =  employeeList.stream().reduce(Employee::getDeptName, (x,y)->).max(Comparator.)
//		Print max salary of an employee from each departement
//		Print max/min employees salary from the given collection.
//		print employee details working in each departement
//			
				Map<String, Optional<Employee>> maxSalOfEmpFromEachDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.maxBy(Comparator.comparing(Employee::getEmpSalary))));
				System.out.println(maxSalOfEmpFromEachDept);
				
				Optional<Employee> maxSalOfEmpFromCollection = employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getEmpSalary)));
				System.out.println(maxSalOfEmpFromCollection);
				Optional<Employee> minSalOfEmpFromCollection = employeeList.stream().collect(Collectors.minBy(Comparator.comparing(Employee::getEmpSalary)));
				System.out.println(minSalOfEmpFromCollection);
				
				Map<String, List<Employee>> empDetailsFromEachDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptName));
				System.out.println(empDetailsFromEachDept);
	}

}
