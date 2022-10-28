package com.medplus.employee.main;

import com.medplus.employee.beans.Department;
import com.medplus.employee.service.DepartmentService;
import com.medplus.employee.service.DepartmentServiceImpl;

public class AddDepartment {

	public static void main(String[] args) {
		DepartmentService service = new DepartmentServiceImpl();
		Department dept = new Department(40, "QA", "Hyd");
		int rows = service.addDepartment(dept);
		if (rows > 0)
			System.out.println("inserted");
		else
			System.out.println("not inserted");
	}
}
