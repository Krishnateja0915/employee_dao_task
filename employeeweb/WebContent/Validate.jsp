<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% String name = request.getParameter("uname");
		String pass = request.getParameter("pwd");
		HttpSession sessionObj = request.getSession();
		sessionObj.setAttribute("uname", name);
		if(name.equals("admin") && pass.equals("admin")) {%>
			<jsp:forward page="GetEmployees"></jsp:forward>
		<%}else if(name.isBlank() || pass.isBlank()){%>
			<jsp:include page="Login.jsp"></jsp:include>
			<p style="color:red">fields shouldn't empty</p>
		<%} else {%>
			<jsp:forward page="GetEmployees"></jsp:forward>
		<%} %>
</body>
</html>