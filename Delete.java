package org.ncu.demo.Project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Delete() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.print("<title>Delete</title>");

		HttpSession session = request.getSession();

		int aadhar = (int) session.getAttribute("aadhar");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/aadhar", "Anjaan", "@nj@@n");

			String query = "delete from info where Aadhar_Number = ?";

			PreparedStatement pstmt = connect.prepareStatement(query);

			pstmt.setInt(1, aadhar);

			int res = pstmt.executeUpdate();

			if (res == 1) {
				out.print("Deleted");

				response.sendRedirect("/demoapp/Project/project_Home.jsp");
			} else {
				out.print("Error");
			}

			connect.close();

		} catch (SQLException | ClassNotFoundException e) {
			System.out.print(e);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
