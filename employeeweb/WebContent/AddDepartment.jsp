<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="deptForm.css"/>
</head>
<body>
<div class="bg-container">
	<form action="AddDepartment" method="post">
		<h1>Add Department Form</h1>
		<div>
			<label for="deptname">Enter Department Name</label>
			<input type="text" id="deptname" name="deptname"/>
			${deptnameError}
		</div>
		<div>
			<label for="location">Enter Location</label>
			<select name="location" id="location">
				<option>Hyderabad</option>
				<option>Bangalore</option>
				<option>Mumbai</option>
				<option>Chennai</option>
			</select>
		</div>
		<input type="submit" value="Submit" class="submit"/>
		<a href="GetDepartments">Back</a>
	</form>
	</div>
</body>
</html>