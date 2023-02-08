package com.aakash;

import java.io.IOException;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.jsse.PEMFile;

import java.sql.*;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<h2>Thank You For Registering</h2>");
		
//		 Getting Values from Form Fields
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String course = request.getParameter("course");
		
		pw.println("<br/><The Following are Details you Entered>");
		pw.println("<h3> FirstName : " + firstname +"</h3>");
		pw.println("<h3> LastName : "  + lastname +"</h3>");
		pw.println("<h3> Email : "+email+"</h3>");
		pw.println("<h3> Gender : "+gender+"</h3>");
		pw.println("<h3> Course Opted For : "+course+"</h3>");
		
		
//		 JDBC CONNECTION
		
//		 Add Mysql Connector
//		(firstname,lastname,email,gender,course)
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8111/aakash","root","");
			PreparedStatement ps = conn.prepareStatement("insert into servlet_register_form values(?,?,?,?,?)");
			ps.setString(1,firstname);
			ps.setString(2,lastname);
			ps.setString(3,email);
			ps.setString(4,gender);
			ps.setString(5,course);
			int x= ps.executeUpdate();
			ps.close();
			if(x>0) {
				pw.println("<br/> Data Submitted Successfully");
			}
			else {
			pw.println("<br/> Submission Failed!...");}
			
			
		} catch (Exception e) {
			pw.println(e);
		}
		
 		
		
		pw.close();
		
	}
	

}
