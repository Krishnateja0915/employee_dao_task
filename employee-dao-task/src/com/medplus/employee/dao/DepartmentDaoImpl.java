package com.medplus.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.medplus.employee.beans.Department;
import com.medplus.employee.utils.DBConnection;
import com.medplus.employee.utils.DBQueries;

public class DepartmentDaoImpl implements DepartmentDao {
	private static Connection conn;
	private static PreparedStatement pst;
	private static ResultSet rs;
	
	@Override
	public int addDepartment(Department dept) {
		conn = DBConnection.getConnection();
		int rows = 0;
		try {
			pst = conn.prepareStatement(DBQueries.ADDDEP);
			pst.setInt(1, dept.getDeptno());
			pst.setString(2, dept.getDeptName());
			pst.setString(3, dept.getLocation());
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
	public Department getDeptno(String deptName) {
		conn = DBConnection.getConnection();
		Department dept = null;
		try {
			pst = conn.prepareStatement(DBQueries.GETDEPTNOBYDEPTNAME);
			pst.setString(1, deptName);
			rs = pst.executeQuery();
			if(rs.next()) {
				dept = new Department();
				dept.setDeptno(rs.getInt(1));
				dept.setDeptName(rs.getString(2));
				dept.setLocation(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBConnection.close();
		}
		return dept;
	}

	@Override
	public String getDeptName(int deptno) {
		conn = DBConnection.getConnection();
		String deptName = "";
		try {
			pst = conn.prepareStatement(DBQueries.GETDEPTNAMEBYDEPTNO);
			pst.setInt(1, deptno);
			rs = pst.executeQuery();
			if(rs.next())
				deptName = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deptName;
	}

}
