package com.medplus.employee.utils;

public class DBQueries {
	public static final String ADDEMP = "insert into employee values(?,?,?,?,?)";
	public static final String DELEMP = "delete from employee where empcode = ?";
	public static final String UPDATEEMP = "update employee set emp_name = ?, salary = ?, doj = ?, deptno = ? where empcode = ?";
	public static final String GETALL = "select * from employee";
	public static final String GETBYID = "select * from employee where empcode = ?";
	public static final String ADDDEP = "insert into department values(?,?,?)";
	public static final String GETDEPTNOBYDEPTNAME = "select * from department where dep_name = ?";
	public static final String GETDEPTNAMEBYDEPTNO = "select dep_name from department where deptno = ?";
	public static final String GETALLDEPARTMENTS = "select * from department";
	public static final String GETUSER = "select * from user where user_name = ?";
	public static final String UPDATEDEPT = "update department set dep_name=?, location=? where deptno=?";
	public static final String GETDEPTBYNO = "select * from department where deptno = ?";
}
