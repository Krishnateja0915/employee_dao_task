package com.medplus.employee.dao;

import com.medplus.employee.beans.Department;

public interface DepartmentDao {
	int addDepartment(Department dept);
	Department getDeptno(String DeptName);
	String getDeptName(int deptno);
}
