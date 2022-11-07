<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="u" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="deptForm.css"/>
</head>
<body>
<div class="bg-container">
	<form action="UpdateDepartment" method="post">
		<div>
			<label for="deptno">Enter Department no</label>
			<input type="text" id="deptno" name="deptno" value="${deptno }" readonly="readonly"/>
		</div>
		<div>
			<label for="deptname">Enter Department Name</label>
			<input type="text" id="deptname" name="deptname" value="${deptname }" readonly="readonly"/>
		</div>
		<div>
			<label for="location">Enter Location</label>
			<select name="location" id="location">
				<option <u:if test="${location eq 'Hyderabad'}">selected</u:if>>Hyderabad</option>
				<option <u:if test="${location eq 'Bangalore'}">selected</u:if>>Bangalore</option>
				<option <u:if test="${location eq 'Mumbai'}">selected</u:if>>Mumbai</option>
				<option <u:if test="${location eq 'Chennai'}">selected</u:if>>Chennai</option>
			</select>
		</div>
		<input type="submit" value="Submit" class="submit"/>
		<a href="GetDepartments">Back</a>
	</form>
	</div>
</body>
</html>