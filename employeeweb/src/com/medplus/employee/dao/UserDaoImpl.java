package com.medplus.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.medplus.employee.beans.User;
import com.medplus.employee.utils.DBConnection;
import com.medplus.employee.utils.DBQueries;

public class UserDaoImpl implements UserDao {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	@Override
	public User getUser(String username) {
		conn = DBConnection.getConnection();
		User user = null;
		try {
			pst = conn.prepareStatement(DBQueries.GETUSER);
			pst.setString(1, username);
			rs = pst.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setRole(rs.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBConnection.close();
		}
		return user;
	}
	
}
