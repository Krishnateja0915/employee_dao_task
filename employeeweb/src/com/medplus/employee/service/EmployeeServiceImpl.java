package com.medplus.employee.service;

import java.util.ArrayList;
import java.util.List;

import com.medplus.employee.beans.Department;
import com.medplus.employee.beans.Employee;
import com.medplus.employee.dao.EmployeeDao;
import com.medplus.employee.dao.EmployeeDaoImpl;
import com.medplus.employee.dto.EmployeeDto;

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
	public List<EmployeeDto> getAll() {
		List<Employee> emplist = dao.getAll();
		List<EmployeeDto> emplistDto = new ArrayList<EmployeeDto>();
		DepartmentService service = new DepartmentServiceImpl();
		emplist.forEach(e -> {
			EmployeeDto emp = new EmployeeDto();
			emp.setEmpcode(e.getEmpcode());
			emp.setEmpname(e.getEmpname());
			emp.setSalary(e.getSalary());
			emp.setDoj(e.getDoj());
			emp.setDeptname(service.getDeptName(e.getDeptno()));
			emplistDto.add(emp);
		});
		return emplistDto;
	}

	@Override
	public Employee getById(int empcode) {
		return dao.getById(empcode);
	}
}