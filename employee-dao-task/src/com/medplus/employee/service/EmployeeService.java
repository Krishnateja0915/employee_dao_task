package com.medplus.employee.service;

import java.util.List;

import com.medplus.employee.beans.Employee;

public interface EmployeeService {
	int addEmployee(Employee employee, String deptName);
	int deleteEmployee(int empcode);
	int updateEmployee(Employee employee);
	List<Employee> getAll();
	Employee getById(int empcode);
}
