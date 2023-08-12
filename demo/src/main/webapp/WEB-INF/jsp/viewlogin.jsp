<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
			    <th>Id</th>
				<th>Account</th>
				<th>password</th>
				<th>Permission</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${list}" varStatus="status">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.account}</td>
					<c:choose>
					<c:when test="${getdata.account == user.account}">
					<td><button>edit</button></td>
					</c:when>
					</c:choose>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>