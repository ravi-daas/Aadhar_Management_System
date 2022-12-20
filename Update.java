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

public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Update() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.print("<title>Update</title>");

		int aadhar = 0;
		int aadhar1=0;
		String name=null;
		String father_name=null;
		String dob=null;
		long phn_number=0;
		String village_city=null;
		String district=null;
		int pin_code=0;
		String state=null;

		HttpSession session = request.getSession();
		
		aadhar = (int) session.getAttribute("aadhar");
		
		String query = "select * from info where Aadhar_Number=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/aadhar", "Anjaan", "@nj@@n");

			PreparedStatement pstmt = connect.prepareStatement(query);
			
			pstmt.setInt(1, aadhar);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {

				name = rs.getString(2);

				father_name = rs.getString(3);;

				dob = rs.getString(4);
				
				phn_number = rs.getLong(5);

				village_city = rs.getString(6);

				district = rs.getString(7);
						
				pin_code = rs.getInt(8);

				state = rs.getString(9);
			}
			
			out.print("<form method='POST' action='Update' ><label for=\"aadhar\">Aadhar Number</label>\n"
					+ "	<input type=\"text\" id=\"aadhar\" name=\"aadhaR\" value ='"+aadhar+"' readonly><br><br>\n"
					+"\n"
					+ "<label for=\"fuName\">Full Name</label>\n"
					+ "	<input type=\"text\" id=\"fuName\" name=\"fname\" value ='"+name+"' required><br><br>\n"
					+ "	\n"
					+ "	<label for=\"fatherName\">Father Name</label>\n"
					+ "	<input type=\"text\" id=\"fatherName\" name=\"fathername\" value ='"+father_name+"'required><br><br>\n"
					+ "	\n"
					+ "	<label for=\"doB\">Date of Birth</label>\n"
					+ "	<input type=\"date\" id=\"doB\" name=\"dob\" min=\"1900-01-01\" max=\"2022-12-20\" value ='"+dob+"' required><br><br>	\n"
					+ "	\n"
					+ "	<label for=\"mobileNumber\">Mobile Number</label>\n"
					+ "	<input type=\"tel\" id=\"mobileNumber\" name=\"mobilenumber\" value ='"+phn_number+"' pattern=\"[0-9]{10}\"\n"
					+ "       required><br><br>\n"
					+ "	\n"
					+ "	<label for=\"gaav_Sheher\">Village/City</label>\n"
					+ "	<input type=\"text\" id=\"gaav_Sheher\" name=\"gaav_sheher\" value ='"+village_city+"' required><br><br>\n"
					+ "	\n"
					+ "	<label for=\"jiLo\">District</label>\n"
					+ "	<input type=\"text\" id=\"jiLo\" name=\"jilo\" value ='"+district+"' required><br><br>\n"
					+ "	\n"
					+ "	<label for=\"pin_Code\">PIN-CODE</label>\n"
					+ "	<input type=\"number\" id=\"pin_Code\" name=\"pin_code\" min=\"100000\" max=\"999999\" value ='"+pin_code+"' required><br><br>\n"
					+ "	\n"
					+ "	<label for=\"rajYa\">State</label>\n"
					+ "	<input type=\"text\" id=\"rajYa\" name=\"rajya\" value ='"+state+"' required><br><br>"
							+ "<input type=\"submit\" value=\"Submit\"></form>");
		}catch(SQLException | ClassNotFoundException e) {
			System.out.print(e);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		
		out.print("POST");
		
		String aadhar = request.getParameter("aadhaR");
		
		int Aadhar_Number = Integer.parseInt(aadhar);
		
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
		
		try {
			 
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/aadhar", "Anjaan", "@nj@@n");
			
			String query = "update info set Name=?, Father_Name=?, Date_of_Birth=?, Phn_Number=?, Village_City=?, District=?, PINCODE=?, state=? where Aadhar_Number = '"+Aadhar_Number+"'";

			PreparedStatement pstmt = connect.prepareStatement(query);
			
			pstmt.setString(1, name);
			pstmt.setString(2, father_name);
			pstmt.setString(3, dob);
			pstmt.setLong(4, mobile_number);
			pstmt.setString(5, village_city);
			pstmt.setString(6, district);
			pstmt.setInt(7, pin_code);
			pstmt.setString(8, state);			
			
			int res = pstmt.executeUpdate();
			
			if(res==1) {
				response.sendRedirect("/demoapp/Project/logIn.jsp");
			}else {
				out.print("Something is Wrong");
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			System.out.print(e);
		}
		
	}

}
