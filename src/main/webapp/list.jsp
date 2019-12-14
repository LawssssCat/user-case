<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>gender</th>
			<th>age</th>
			<th>address</th>
			<th>QQ</th>
			<th>e-mail</th>
		</tr>
		<c:forEach varStatus="index" var="user"  items="${userList }" >
			<tr>
				<td>${user.id }</td>
				<td>${user.name }</td>
				<td>${user.gender }</td>
				<td>${user.age }</td>
				<td>${user.address }</td>
				<td>${user.qq }</td>
				<td>${user.email}</td>
			</tr>
		</c:forEach>		
	</table>
</body>
</html>