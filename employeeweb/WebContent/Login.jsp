<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	.bg-container {
		height: 100vh;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.login-form {
		width: 350px;
		background-color: #f2f4fa;
		padding: 30px;
		border-radius: 5px;
		display: flex;
		flex-direction: column;
	}
	.input-container {
		display: flex;
		flex-direction: column;
		margin-bottom: 10px;
	}
	.submit {
		background-color: #5171f0;
		color: #ffffff;
		border: 0;
		padding: 8px 16px;
		cursor: pointer;
	}
	input {
		padding: 5px;
		border-radius: 5px;
		margin-bottom: 10px;
	}
	label {
		font-size: 16px;
		color: #a89f9e;
		margin-bottom: 10px;
	}
</style>
</head>
<body>
	<div class="bg-container">
		<form action="Validate" method="post" class="login-form">
			<div class="input-container">
				<label for="user">Enter User name</label> 
				<input type="text" name="uname" id="user" value="${username}" placeholder="Enter Username"/>
				${usernameError}
			</div>
			<div class="input-container">
				<label for="password">Enter Password</label>
				<input type="password" name="password" id="password" placeholder="Enter Password" required/>
				${errorMsg}
			</div>
			<input type="submit" value="Submit" class="submit" />
		</form>
	</div>
</body>
</html>