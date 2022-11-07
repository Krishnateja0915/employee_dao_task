<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="w" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	body {
		margin: 30px;
	}
	h1 {
		text-align: center;
	}
	a {
		text-align: center;
		font-size: 20px;
		border: 1px solid;
		text-decoration: none;
		padding: 4px 10px;
		width: 150px;
	}
	div {
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
	.links {
		display: flex;
		flex-direction: column;
		align-items: center;
		margin-top: 70px;
	}
</style>
</head>
<body>
	<div>
		<%
		HttpSession sessionObj = request.getSession();
		String username = (String)sessionObj.getAttribute("username");
		String role = (String)sessionObj.getAttribute("role");
		if(role.equals("admin")){%>
		<h1 style = "color: #737785;">Welcome Administrator</h1>
		<%} else{%>
		<h1 style = "color: #737785;">Welcome ${username}</h1>
		<%} %>
		<a href="Login.jsp">Logout</a>
	</div>
	<div class="links">
		<a href="GetEmployees">View Employees</a>
		<br/><br/>
		<%if(role.equals("admin")) {%>
			<a href="GetDepartments">View Departments</a>
		<%} %>
	</div>
	<br/><br/>
</body>
</html>