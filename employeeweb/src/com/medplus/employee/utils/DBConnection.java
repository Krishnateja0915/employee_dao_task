package com.medplus.employee.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DBConnection {
	private static Connection conn = null;
	public static Connection getConnection() {
		try {
			DriverManager.registerDriver(new Driver());
			String url = "jdbc:mysql://localhost:3306/sample";
			conn = DriverManager.getConnection(url, "root", "Advaith@0915");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
