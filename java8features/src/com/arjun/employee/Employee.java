package com.arjun.employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
	
	private int id;
	private String name;
	private int age;
	private String gender;
	private String department;
	private int yearOfJoining;
	private double salary;
	public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getYearOfJoining() {
		return yearOfJoining;
	}
	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
				+ department + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + "]";
	}
	
//	public static List<Employee> getEmployeeList(){
//        List<Employee> employeeList = new ArrayList<Employee>();
//
//        employeeList.add(new Employee(111, "Jennifer", 22, "Female", "HR", 2017, 55000.0));
//        employeeList.add(new Employee(112, "Rohit", 35, "Male", "Sales And Marketing", 2019, 23500.0));
//        employeeList.add(new Employee(113, "Shubman", 29, "Male", "Infrastructure", 2019, 28000.0));
//        employeeList.add(new Employee(114, "Rinku", 28, "Male", "Product Development", 2020, 62500.0));
//        employeeList.add(new Employee(115, "Aaditi", 41, "Female", "HR", 2022, 29700.0));
//        employeeList.add(new Employee(116, "Mahendra", 43, "Male", "Security And Transport", 2023, 20500.0));
//        employeeList.add(new Employee(117, "Nitish", 35, "Male", "Account And Finance", 2019, 37000.0));
//        employeeList.add(new Employee(118, "Aditya", 31, "Male", "Product Development", 2019, 34500.0));
//        employeeList.add(new Employee(119, "Monika", 24, "Female", "Sales And Marketing", 2021, 21500.0));
//        employeeList.add(new Employee(120, "Aman", 38, "Male", "Security And Transport", 2021, 31000.5));
//        employeeList.add(new Employee(121, "Sangeeta", 27, "Female", "Infrastructure", 2021, 35000.0));
//        employeeList.add(new Employee(122, "Joshi", 25, "Male", "Product Development", 2020, 29000.0));
//        employeeList.add(new Employee(123, "Jeddy", 27, "Female", "Account And Finance", 2020, 29000.0));
//        employeeList.add(new Employee(124, "Niden", 24, "Male", "Sales And Marketing", 2020, 30200.5));
//        employeeList.add(new Employee(125, "Saig", 23, "Male", "Infrastructure", 2019, 42700.0));
//        employeeList.add(new Employee(126, "Saey", 26, "Female", "Product Development", 2018, 38900.0));
//        employeeList.add(new Employee(127, "Shreyas", 25, "Male", "Product Development", 2018, 35700.0));
//
//        return employeeList;
//    }
	
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jennifer", 22, "Female", "HR", 2017, 55000.0));
        employeeList.add(new Employee(112, "Rohit", 35, "Male", "Sales And Marketing", 2019, 23500.0));
        employeeList.add(new Employee(113, "Shubman", 29, "Male", "Infrastructure", 2019, 28000.0));
        employeeList.add(new Employee(114, "Rinku", 28, "Male", "Product Development", 2020, 62500.0));
        employeeList.add(new Employee(115, "Aaditi", 41, "Female", "HR", 2022, 29700.0));
        employeeList.add(new Employee(116, "Mahendra", 43, "Male", "Security And Transport", 2023, 20500.0));
        employeeList.add(new Employee(117, "Nitish", 35, "Male", "Account And Finance", 2019, 37000.0));
        employeeList.add(new Employee(118, "Aditya", 31, "Male", "Product Development", 2019, 34500.0));
        employeeList.add(new Employee(119, "Monika", 24, "Female", "Sales And Marketing", 2021, 21500.0));
        employeeList.add(new Employee(120, "Aman", 38, "Male", "Security And Transport", 2021, 31000.5));
        employeeList.add(new Employee(121, "Sangeeta", 27, "Female", "Infrastructure", 2021, 35000.0));
        employeeList.add(new Employee(122, "Joshi", 25, "Male", "Product Development", 2020, 29000.0));
        employeeList.add(new Employee(123, "Jeddy", 27, "Female", "Account And Finance", 2020, 29000.0));
        employeeList.add(new Employee(124, "Niden", 24, "Male", "Sales And Marketing", 2020, 30200.5));
        employeeList.add(new Employee(125, "Saig", 23, "Male", "Infrastructure", 2019, 42700.0));
        employeeList.add(new Employee(126, "Saey", 26, "Female", "Product Development", 2018, 38900.0));
        employeeList.add(new Employee(127, "Shreyas", 25, "Male", "Product Development", 2018, 35700.0));

		
		long count = employeeList.stream().count();
		//System.out.println(employeeList.stream().count());
		System.out.println("Count using count() :" + count);
		
		long count1 = employeeList.stream().collect(Collectors.counting());
		System.out.println("Count using Collectors.counting() : " + count1);
		
		//Asscending order
//		List<Employee> employeeSortedList = employeeList
//				.stream()
//				.sorted((o1, o2) -> (int) (o1.getSalary() - o2.getSalary()))
//				.collect(Collectors.toList());
//		System.out.println(employeeSortedList);
		//employeeList.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);
	
		//descending order
//		List<Employee> employeeSortedList = employeeList
//				.stream()
//				.sorted((o1, o2) -> (int) (o2.getSalary() - o1.getSalary()))
//				.collect(Collectors.toList());
//		System.out.println(employeeSortedList);
		//employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);
		
		System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())));
		System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())));
		
		System.out.println(employeeList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList()));
	}
}



