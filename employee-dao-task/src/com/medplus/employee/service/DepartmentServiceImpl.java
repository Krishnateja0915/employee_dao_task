package com.medplus.employee.service;

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
		return null;
	}
}
