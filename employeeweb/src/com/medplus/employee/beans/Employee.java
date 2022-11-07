package com.medplus.employee.beans;

public class Employee {
	private int empcode;
	private String empname;
	private double salary;
	private String doj;
	private int deptno;
	
	public Employee() {
		
	}
	
	public Employee(int empcode, String empname, double salary, String doj) {
		this.empcode = empcode;
		this.empname = empname;
		this.salary = salary;
		this.doj = doj;
	}
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getEmpcode() {
		return empcode;
	}
	public void setEmpcode(int empcode) {
		this.empcode = empcode;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	@Override
	public String toString() {
		return "Employee [empcode=" + empcode + ", empname=" + empname + ", salary=" + salary + ", doj=" + doj
				+ ", deptno=" + deptno + "]";
	}
}
