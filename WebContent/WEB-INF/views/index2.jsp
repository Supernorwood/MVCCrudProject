<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/master.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lions Never Die!!!</title>
<%@ include file="head.jsp"%>
</head>
<body>
	<h2><strong>Lions Never Die</strong></h2>

	<form:form action="getLion.do" method="post" modelAttribute="idForm">
		<form:input path="id" />
		<form:errors path="id" />


		<input type="submit" value="Get a Lion">
	</form:form>

	<p>
		All Lions: <br>
		<c:forEach var="lio" items="${list }">
		<div class="container">
  <div class="row">
    <div class="col-sm">
      ${lio.id } <a href="info.do?id=${lio.id }	" style="color:orange;"><br>${lio.name }</a>
    </div>
    <div class="col-sm">
      <img src="${lio.imageUrl }" width="500px" height="300px">
      
    </div>
    <div class="col-sm" >
      	<form method="post" action="delete.do">
				<input type="submit" value="Delete"> <input type="hidden"
					name="id" value="${lio.id }">
			</form>
			<form method="post" action="update.do">
				<input type="submit" value="Update"> <input type="hidden"
					name="id" value="${lio.id }">
			</form>
    </div>
  </div>
</div>

		<%-- 	${lio.id } <a href="info.do?id=${lio.id }	" style="color:orange;">${lio.name }</a>
			<br>
			<img src="${lio.imageUrl }" width="500px" height="300px">

			<form method="post" action="delete.do">
				<input type="submit" value="Delete"> <input type="hidden"
					name="id" value="${lio.id }">
			</form>
			<form method="post" action="update.do">
				<input type="submit" value="Update"> <input type="hidden"
					name="id" value="${lio.id }">
			</form> --%>

<%-- ${lio.id } ${lio.name }<br>
			<img src="${lio.imageUrl }">
			<br> --%>
		</c:forEach>
	</p>

	<%--
<c:if test="${not empty bestLion }">
	The best giraffe is: ${bestLion}
</c:if>
 --%>
	<p>
		<a href="add.do" style="color:orange;">Add a Lion</a><br>
	<!-- 	<img src="https://i.imgur.com/ZUahSbj.gif"
		width="500px" height="300px"> -->
	</p> 


</body>
</html>