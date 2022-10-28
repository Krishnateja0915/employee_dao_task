package com.medplus.employee.service;

import com.medplus.employee.beans.Department;

public interface DepartmentService {
	int addDepartment(Department dept);
	Department getDeptno(String deptName);
	String getDeptName(int deptno);
}
