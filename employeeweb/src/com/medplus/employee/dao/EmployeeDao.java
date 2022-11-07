package com.medplus.employee.dao;

import java.util.List;

import com.medplus.employee.beans.Employee;

public interface EmployeeDao {
	int addEmployee(Employee employee);
	int deleteEmployee(int empcode);
	int updateEmployee(Employee employee);
	List<Employee> getAll();
	Employee getById(int empcode);
}
