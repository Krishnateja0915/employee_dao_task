package com.medplus.employee.dao;

import java.util.List;

import com.medplus.employee.beans.Department;

public interface DepartmentDao {
	int addDepartment(Department dept);
	Department getDeptno(String DeptName);
	String getDeptName(int deptno);
	List<Department> getdepts();
	int updateDept(Department dept);
	Department getDept(int deptno);
}
