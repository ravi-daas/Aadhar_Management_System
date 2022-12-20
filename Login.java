package org.ncu.demo.Project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int presence = 0;

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		

		int aadhar = Integer.parseInt(request.getParameter("aadhaR"));

		long password = Long.parseLong(request.getParameter("mobilenumber"));

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/aadhar", "Anjaan", "@nj@@n");
			String query = "select * from info where Aadhar_Number = ?";

			PreparedStatement pstmt = connect.prepareStatement(query);

			pstmt.setInt(1, aadhar);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				presence = 1;
				long pass = rs.getLong(5);
				if (pass == password) {
					HttpSession session = request.getSession();
					session.setAttribute("id", session.getId());
					session.setAttribute("aadhar", rs.getInt(1));
					out.print("<h3>Your Details</h3><hr>" + "Aadhar Number: " + rs.getInt(1) + "<br><br>Name: "
							+ rs.getString(2) + "<br><br>Father Name: " + rs.getString(3) + "<br><br>D.O.B: "
							+ rs.getString(4) + "<br><br>Mobile No.: " + rs.getLong(5) + "<br><br>Village/City: "
							+ rs.getString(6) + "<br><br>District: " + rs.getString(7) + "<br><br>PINCODE: "
							+ rs.getInt(8) + "<br><br>State: " + rs.getString(9)
							+ "<hr><form action='Update' method='GET'><input type='submit' value='Update Details'/></form>"
							+ "<br><form action='Delete' method='POST'><input type='submit' value='Delete'/></form>"
							+ "<br><form action='Logout' method='POST'><input type='submit' value='Logout'/></form>");
					out.print("<title>"+rs.getString(2)+"</title>");
				} else {
					out.print(
							"You entered a wrong Aadhar_id or password<br><br> <a href='/demoapp/Project/logIn.jsp'>Log In Again</a>");
				}
			}

			connect.close();

		} catch (SQLException | ClassNotFoundException e) {
			System.out.print(e);
		}

		if (presence == 0) {
			response.sendRedirect("/demoapp/Project/project_Home.jsp");
		}
	}

}
