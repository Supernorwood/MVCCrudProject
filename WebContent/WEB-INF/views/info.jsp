<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/master.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lion Info</title>
</head>
<body>
${lion.name }<br>
${lion.gender }<br>
<img src="${lion.imageUrl }" width="500px" height="400px"><br>

<p>
<a href="home.do" style="color:orange;">Home</a>
</p>


</body>
</html>