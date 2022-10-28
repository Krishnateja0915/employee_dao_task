package com.medplus.employee.main;

import com.medplus.employee.service.EmployeeService;
import com.medplus.employee.service.EmployeeServiceImpl;

public class DeleteEmployee {

	public static void main(String[] args) {
		EmployeeService service = new EmployeeServiceImpl();
		int rows = service.deleteEmployee(103);
		if(rows > 0)
			System.out.println("Deleted");
		else
			System.out.println("not deleted");
	}
}
