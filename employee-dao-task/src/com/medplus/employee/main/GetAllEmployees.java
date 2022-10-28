package com.medplus.employee.main;

import java.util.List;

import com.medplus.employee.beans.Employee;
import com.medplus.employee.service.EmployeeService;
import com.medplus.employee.service.EmployeeServiceImpl;

public class GetAllEmployees {

	public static void main(String[] args) {
		EmployeeService service = new EmployeeServiceImpl();
		List<Employee> emplist = service.getAll();
		emplist.forEach((e) -> System.out.println(e));
	}

}
