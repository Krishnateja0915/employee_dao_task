package com.medplus.employee.service;

import java.util.List;

import com.medplus.employee.beans.Department;
import com.medplus.employee.beans.Employee;
import com.medplus.employee.dao.EmployeeDao;
import com.medplus.employee.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDao dao = new EmployeeDaoImpl();
	
	@Override
	public int addEmployee(Employee employee, String deptName) {
		DepartmentService service = new DepartmentServiceImpl();
		Department dept = service.getDeptno(deptName);
		employee.setDeptno(dept.getDeptno());
		return dao.addEmployee(employee);
	}
	

	@Override
	public int deleteEmployee(int empcode) {
		return dao.deleteEmployee(empcode);
	}

	@Override
	public int updateEmployee(Employee employee, String deptName) {
		DepartmentService service = new DepartmentServiceImpl();
		Department dept = service.getDeptno(deptName);
		employee.setDeptno(dept.getDeptno());
		return dao.updateEmployee(employee);
	}

	@Override
	public void getAll() {
		List<Employee> emplist = dao.getAll();
		DepartmentService service = new DepartmentServiceImpl();
		emplist.forEach(e -> {
			System.out.println(e.getEmpcode() + " " + e.getEmpname() + " " + e.getSalary() + " " + 
		e.getDoj() + " " + service.getDeptName(e.getDeptno()));
		});
	}

	@Override
	public Employee getById(int empcode) {
		return dao.getById(empcode);
	}
}