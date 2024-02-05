
<%@page import="java.sql.ResultSet"%>
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
	<% ResultSet userList =  (ResultSet)request.getAttribute("DisplayUser"); %>
	

	<table border="">
		<tr>
			<th>User Id</th>
			<th>User Name</th>
			<th>User Email</th>
			<th>User Address</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>

		<% while(userList.next()) { %>
		<tr>
			<td><%= userList.getInt(1) %></td>
			<td><%= userList.getString(2) %></td>
			<td><%= userList.getString(3) %></td>
			<td><%= userList.getLong(4) %></td>

			<td><a href="UpdateUser?id=<%= userList.getInt(1) %>">Update</a></td>
			<td><a href="DeleteUser?id=<%= userList.getInt(1) %>">Delete</a></td>
			
		</tr>
		<% } %>
	</table>
</body>
</html>