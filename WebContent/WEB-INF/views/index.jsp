<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/master.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lions Never Die!!!</title>
</head>
<body>
<h2>Lions Never Die</h2>

<form action="getLion.do" method="post">

<input type="number" name="lionId">
<input type="submit" name="Get a Lion">
</form>

<c:if test="${not empty bestLion }">
	The best lion is: ${bestLion}
</c:if>

</body>
</html>