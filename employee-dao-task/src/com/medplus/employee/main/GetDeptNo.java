package com.medplus.employee.main;

import com.medplus.employee.beans.Department;
import com.medplus.employee.service.DepartmentService;
import com.medplus.employee.service.DepartmentServiceImpl;

public class GetDeptNo {

	public static void main(String[] args) {
		DepartmentService service = new DepartmentServiceImpl();
		Department dept = service.getDeptno("Testing");
		System.out.println(dept);
	}
}
