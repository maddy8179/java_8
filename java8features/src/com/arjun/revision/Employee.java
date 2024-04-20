package com.arjun.revision;

public class Employee {

	private int empid;
	private String empName;
	private String deptName;
	private double empSalary;
	public Employee(int empid, String empName, String deptName, double empSalary) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.deptName = deptName;
		this.empSalary = empSalary;
	}
	
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}


	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empName=" + empName + ", deptName=" + deptName + ", empSalary="
				+ empSalary + "]";
	}
}
