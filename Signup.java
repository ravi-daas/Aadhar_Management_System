package org.ncu.demo.Project;

import java.sql.*;
import java.math.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Signup() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		int aadhar = (int) (Math.random() * 100000000);

		String name = request.getParameter("fname");

		String father_name = request.getParameter("fathername");

		String dob = request.getParameter("dob");
		
		String phn = request.getParameter("mobilenumber");

		long mobile_number = Long.parseLong(phn);

		String village_city = request.getParameter("gaav_sheher");

		String district = request.getParameter("jilo");

		String pin = request.getParameter("pin_code");
				
		int pin_code = Integer.parseInt(pin);

		String state = request.getParameter("rajya");
		
	if(name.length()==0||father_name.length()==0||dob.length()==0||phn.length()==0||village_city.length()==0||district.length()==0||pin.length()==0||state.length()==0) {
		out.print("Something is Missing, fill it carefully!"
				+ "<br><br><a href='/demoapp/Project/signUp.jsp'>Sign Up</a>");
			
	}else {
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/aadhar", "Anjaan", "@nj@@n");
			String query = "insert into info values (?,?,?,?,?,?,?,?,?)";

			PreparedStatement pstmt = connect.prepareStatement(query);
			
			pstmt.setInt(1, aadhar);
			pstmt.setString(2, name);
			pstmt.setString(3, father_name);
			pstmt.setString(4, dob);
			pstmt.setLong(5, mobile_number);
			pstmt.setString(6, village_city);
			pstmt.setString(7, district);
			pstmt.setInt(8, pin_code);
			pstmt.setString(9, state);

			int a = pstmt.executeUpdate();

			System.out.println(a);
			
			if(a==1) {
				out.print("Successfully Registered<br><br>");
				out.print("Username/Aadhar No. :- "+ aadhar+"<br><br>");
				out.print("Password/Phn No. :- "+ mobile_number);
				out.print("<br><br><a href = '/demoapp/Project/logIn.jsp'>Log In</a>");
			}

			connect.close();

		} catch (SQLException | ClassNotFoundException e) {
			System.out.print(e);
		}

		}
	
	System.out.println(request.getQueryString());

	}

}
