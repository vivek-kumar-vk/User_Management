package com.usermanagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(value = {"/updateUser"})
public class UpdatedUser extends HttpServlet{
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
			String query = "UPDATE user1 SET userName=? , userEmail=? , userAddress=? WHERE userId=?";
			PreparedStatement preparedStatement = getConnection().prepareStatement(query);


			preparedStatement.setString(1,name);
			preparedStatement.setString(2, email);
			preparedStatement.setLong(3, phoneNum);
			preparedStatement.setInt(4, id);

			preparedStatement.executeUpdate();

			preparedStatement.close();
			getConnection().close();

			resp.sendRedirect("Success.jsp?msg=Updated"); 
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

