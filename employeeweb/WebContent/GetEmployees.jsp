<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
</head>
<body>
	<%HttpSession sessionObj = request.getSession();
	Object uname = sessionObj.getAttribute("username");
	if(uname.equals("admin")) {%>
	<a href="AddEmployee.jsp">Add new Employee</a> <br> <br>
	<%} %>
	<div>
		<table>
			<caption style="font-size:26px; margin-bottom:20px">Employee Details</caption>
			<tr>
				<th>Emp code</th>
				<th>Emp name</th>
				<th>Salary</th>
				<th>Date joined</th>
				<th>Department name</th>
				<%if(uname.equals("admin")) {%>
				<th colspan=2>Actions</th>
				<%} %>
			</tr>
			<j:forEach var="emp" items="${empls}">
				<tr>
					<td>${emp.empcode}</td>
					<td>${emp.empname}</td>
					<td>${emp.salary}</td>
					<td>${emp.doj}</td>
					<td>${emp.deptname}</td>
					<%if(uname.equals("admin")) {%>
					<td><a href="UpdateEmployee?code=${emp.empcode}" class="action-link">update</a></td>
					<td><a href="DeleteEmployee?code=${emp.empcode}" class="action-link">delete</a></td>
					<%} %>
				</tr>
			</j:forEach>
		</table>
	</div>
	<a href="WelcomePage.jsp">Back</a>
</body>
</html>