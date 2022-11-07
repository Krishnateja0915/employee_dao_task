package com.medplus.employee.service;

import java.util.List;

import com.medplus.employee.beans.Department;

public interface DepartmentService {
	int addDepartment(Department dept);
	Department getDeptno(String deptName);
	String getDeptName(int deptno);
	List<Department> getAllDepartments();
	int updateDept(Department dept);
	Department getDept(int deptno);
}
