<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="formStyle.css"/>
</head>
<body>
	<%HttpSession sessionObj = request.getSession();
	Object depts = sessionObj.getAttribute("depts");%>
	<div class='bg-container'>
		<form action="AddEmployee" method="post">
			<h1>Add Employee</h1>
			<div>
				<label>Enter Employee name</label>
				<input type="text" name="name" value="${name}" placeholder="Enter name" required/>
				${nameError}
			</div>
			<div>
				<label>Enter Employee salary</label>
				<input type="text" name="salary" value="${salary}" placeholder="Enter salary" required/>
				${salaryError}
			</div>
			<div>
				<label>Enter Employee DOJ</label>
				<input type="date" name="doj" value="${doj}" required/>
			</div>
			<div>
				<label>Enter Department name</label>
				<select name="deptname">
					<a:forEach var="dept" items="${depts}">
						<option <a:if test="${dept.deptName eq deptname}">selected</a:if>>${dept.deptName}</option>
					</a:forEach>
				</select>
			</div>
			<input type="submit" class="submit" value="Submit"/>
			<a href="GetEmployees">Back</a>
		</form>
	</div>
</body>
</html>