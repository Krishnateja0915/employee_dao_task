<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
	div {
		display: flex;
		justify-content: center;
	}
	a {
		font-size: 20px;
		width: 150px;
		padding: 4px 10px;
		border: 1px solid;
		text-decoration: none;
	}
	table {
		border: 2px solid;
	}
	tr {
		border: 2px solid;
	}
	th {
		border: 2px solid;
	}
	td {
		border: 2px solid;
	}
	a {	
		text-decoration: none;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<a href="AddDepartment.jsp">Add new Department</a> <br> <br>
	<div>
	<table>
		<caption style="font-size:26px; margin-bottom:20px">Department Details</caption>
		<tr>
			<th>Department no</th>
			<th>Department name</th>
			<th>Location</th>
			<th>Actions</th>
		</tr>
		<d:forEach var="dept" items="${depts }">
			<tr>
				<td>${dept.deptno }</td>
				<td>${dept.deptName }</td>
				<td>${dept.location }</td>
				<td><a href="UpdateDepartment?deptno=${dept.deptno}">Update</a></td>
			</tr>
		</d:forEach>
	</table>
	</div>
	<a href="WelcomePage.jsp">Back</a>
</body>
</html>