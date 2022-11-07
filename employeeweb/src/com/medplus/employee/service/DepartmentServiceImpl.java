package com.medplus.employee.service;

import java.util.List;

import com.medplus.employee.beans.Department;
import com.medplus.employee.dao.DepartmentDao;
import com.medplus.employee.dao.DepartmentDaoImpl;

public class DepartmentServiceImpl implements DepartmentService {
	DepartmentDao dao = new DepartmentDaoImpl();
	
	@Override
	public int addDepartment(Department dept) {
		return dao.addDepartment(dept);
	}

	@Override
	public Department getDeptno(String deptName) {
		return dao.getDeptno(deptName);
	}

	@Override
	public String getDeptName(int deptno) {
		return dao.getDeptName(deptno);
	}

	@Override
	public List<Department> getAllDepartments() {
		return dao.getdepts();
	}

	@Override
	public int updateDept(Department dept) {
		return dao.updateDept(dept);
	}

	@Override
	public Department getDept(int deptno) {
		return dao.getDept(deptno);
	}
}
