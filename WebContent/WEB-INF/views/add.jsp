<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/master.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Enter Lion Data</title>
</head>
<body>
	<h3>Enter data about your Lion</h3>
	
	
	<form:form action="addLion.do" method="post" modelAttribute="lion">
	Name: <form:input path="name" />
		<form:errors path="name" />
		<br>
		

   
 	Gender: <form:input path="gender" />
		<form:errors path="gender" />
		<br> 

		
	Image URL: <form:input path="imageUrl" />
		<form:errors path="imageUrl" />
		<br>
		
		<input type="submit" value="Add a Lion">
	</form:form>

</body>
</html>