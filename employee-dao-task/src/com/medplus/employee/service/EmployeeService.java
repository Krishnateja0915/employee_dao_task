package com.medplus.employee.service;

import com.medplus.employee.beans.Employee;

public interface EmployeeService {
	int addEmployee(Employee employee, String deptName);
	int deleteEmployee(int empcode);
	int updateEmployee(Employee employee, String deptName);
	void getAll();
	Employee getById(int empcode);
}
