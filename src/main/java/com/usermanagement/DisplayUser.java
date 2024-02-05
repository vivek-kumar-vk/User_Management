package com.usermanagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayUser")
public class DisplayUser extends HttpServlet {

	public static Connection getConnection() {
		Connection con = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");

		} catch (Exception e) {
			e.printStackTrace();

		}
		return con;

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String query = "SELECT * FROM user1";
			PreparedStatement preparedStatement = getConnection().prepareStatement(query);

			ResultSet resultSet = preparedStatement.executeQuery();

//			List users = new ArrayList();
//			while (resultSet.next()) {
//				int userId = resultSet.getInt("userId");
//				String userName = resultSet.getString("userName");
//				String userEmail = resultSet.getString("userEmail");
//				long userAddress = resultSet.getLong("userAddress");
//
//				System.out.println("User ID: " + userId + ", User Name: " + userName + ", User Email: " + userEmail
//						+ ", User Address: " + userAddress);
//
//				users.add(userId);
//				users.add(userName);
//				users.add(userEmail);
//				users.add(userAddress);
//			}

			req.setAttribute("DisplayUser", resultSet);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("DisplayUser.jsp");
			requestDispatcher.forward(req, resp);

			getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
