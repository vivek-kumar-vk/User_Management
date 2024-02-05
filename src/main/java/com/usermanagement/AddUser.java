package com.usermanagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddUser")
public class AddUser extends HttpServlet{
	public static Connection  getConnection() {
		Connection  con = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");


			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");


		} catch (Exception e) {
			e.printStackTrace();

		}
		return con;

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		long phoneNum = Long.parseLong(req.getParameter("phnum"));
		
		try {
			String query = "INSERT INTO user1 (userId, userName, userEmail, userAddress) VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStatement = getConnection().prepareStatement(query);
			
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2,name);
			preparedStatement.setString(3, email);
			preparedStatement.setLong(4, phoneNum);
			
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
			getConnection().close();
			
			resp.sendRedirect("Success.jsp?msg=Insert"); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
