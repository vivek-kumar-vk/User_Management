<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% List userList =  (List)request.getAttribute("existingUsers");%>
	<form action="updateUser" method="post">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="text" value = "<%= ((Integer)userList.get(0)).intValue() %>
" name="id" required="required" /></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" value = "<%=(String)userList.get(1)%>" name="name" required="required" /></td>
			</tr>
			<tr>
				<td>Email Id:</td>
				<td><input type="text" value = "<%=(String)userList.get(2)%>" name="email" required="required" /></td>
			</tr>
			<tr>
				<td>Phone Number:</td>
				<td><input type="text" value = "<%=(long)userList.get(3)%>" name="phnum" required="required" /></td>
			</tr>
			<tr />
		</table>
		<br /> <input type="submit" value="Insert Data" required="required" />

	</form>
	<br />
	<a href="index.jsp">Return to Home Page</a>
</body>
</html>