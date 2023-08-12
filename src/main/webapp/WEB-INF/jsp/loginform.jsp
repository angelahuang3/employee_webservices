<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns:mso="urn:schemas-microsoft-com:office:office"
 xmlns:msdt="uuid:C2F41010-65B3-11d1-A29F-00AA00C14882">
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Employee</h1>
	<form:form method="post" action="/checklogin" modelAttibute="command">
		<table>
			<tr>
				<td>Account :</td>
				<td><form:input path="account" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Edit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>