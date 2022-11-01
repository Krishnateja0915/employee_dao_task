package com.medplus.employee.main;

import com.medplus.employee.service.EmployeeService;
import com.medplus.employee.service.EmployeeServiceImpl;

public class GetAllEmployees {

	public static void main(String[] args) {
		EmployeeService service = new EmployeeServiceImpl();
		service.getAll();
	}
}
