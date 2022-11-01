package com.medplus.employee.main;

import com.medplus.employee.service.DepartmentService;
import com.medplus.employee.service.DepartmentServiceImpl;

public class GetDeptName {

	public static void main(String[] args) {
		DepartmentService service = new DepartmentServiceImpl();
		String deptName = service.getDeptName(10);
		System.out.println(deptName);
	}
}
