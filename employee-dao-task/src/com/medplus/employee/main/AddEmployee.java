package com.medplus.employee.main;

import com.medplus.employee.beans.Employee;
import com.medplus.employee.service.EmployeeService;
import com.medplus.employee.service.EmployeeServiceImpl;

public class AddEmployee {

	public static void main(String[] args) {
		EmployeeService service = new EmployeeServiceImpl();
		Employee emp = new Employee(104, "abc", 65000, "2020-07-15");
		int rows = service.addEmployee(emp,"Testing");
		if(rows > 0)
			System.out.println("inserted");
		else
			System.out.println("not inserted");
	}
}
