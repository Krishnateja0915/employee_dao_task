package com.medplus.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.medplus.employee.beans.Employee;
import com.medplus.employee.utils.DBConnection;
import com.medplus.employee.utils.DBQueries;
import com.medplus.employee.utils.DateConversion;

public class EmployeeDaoImpl implements EmployeeDao{
	private Connection conn = null;
	private PreparedStatement pst;
	private ResultSet rs;
	
	@Override
	public int addEmployee(Employee employee) {
		conn = DBConnection.getConnection();
		int rows = 0;
		try {
			pst = conn.prepareStatement(DBQueries.ADDEMP);
			pst.setInt(1, employee.getEmpcode());
			pst.setString(2, employee.getEmpname());
			pst.setDouble(3, employee.getSalary());
			pst.setDate(4, DateConversion.convertDate(employee.getDoj()));
			pst.setInt(5, employee.getDeptno());
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBConnection.close();
		}
		return rows;
	}

	@Override
	public int deleteEmployee(int empcode) {
		conn = DBConnection.getConnection();
		int rows = 0;
		try {
			pst = conn.prepareStatement(DBQueries.DELEMP);
			pst.setInt(1, empcode);
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBConnection.close();
		}
		return rows;
	}

	@Override
	public int updateEmployee(Employee emp) {
		conn = DBConnection.getConnection();
		int rows = 0;
		try {
			pst = conn.prepareStatement(DBQueries.UPDATEEMP);
			pst.setString(1, emp.getEmpname());
			pst.setDouble(2, emp.getSalary());
			pst.setDate(3, DateConversion.convertDate(emp.getDoj()));
			pst.setInt(4, emp.getEmpcode());
			pst.setInt(5, emp.getDeptno());
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBConnection.close();
		}
		return rows;
	}

	@Override
	public List<Employee> getAll() {
		conn = DBConnection.getConnection();
		List<Employee> emplist = new ArrayList<Employee>();
		try {
			pst = conn.prepareStatement(DBQueries.GETALL);
			rs = pst.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpcode(rs.getInt(1));
				emp.setEmpname(rs.getString(2));
				emp.setSalary(rs.getDouble(3));
				emp.setDoj(rs.getDate(4).toString());
				emp.setDeptno(rs.getInt(5));
				emplist.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBConnection.close();
		}
		return emplist;
	}

	@Override
	public Employee getById(int empcode) {
		conn = DBConnection.getConnection();
		Employee emp = null;
		try {
			pst = conn.prepareStatement(DBQueries.GETBYID);
			pst.setInt(1, empcode);
			rs = pst.executeQuery();
			if (rs.next()) {
				emp = new Employee();
				emp.setEmpcode(rs.getInt(1));
				emp.setEmpname(rs.getString(2));
				emp.setSalary(rs.getDouble(3));
				emp.setDoj(rs.getDate(4).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBConnection.close();
		}
		return emp;
	}	
}
