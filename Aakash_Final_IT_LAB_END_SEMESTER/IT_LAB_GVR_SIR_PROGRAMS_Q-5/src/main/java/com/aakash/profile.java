package com.aakash;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.aakash.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.jsse.PEMFile;

/**
 * Servlet implementation class profile
 */
@WebServlet("/profile")
public class profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
//		String loginid = request.getParameter("lgnid");
		String password = request.getParameter("pswd");
		try {
			password=reg.convertToMD5Hash(password);
		} catch (Exception e) {
			pw.println(e);
		}
 		String database_name = "it_lab";
		int resp = 0; 
		
//		JDBC Connection 
//		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8111/"+database_name,"root","");
            Statement stmt = conn.createStatement();
            ResultSet rs  = stmt.executeQuery("select * from registration_form");
			
//			PreparedStatement ps = conn.prepareStatement("select * from registration_form where loginId = ?");
//            ps.setString(1,loginid);
//            ResultSet rs = ps.executeQuery();
//            String[] login_password_result = login.loginId_Password_Check(conn, loginid, password);
            
            
            
			while(rs.next()) {
				
//				if(login_password_result[0]=="1")
				String pswd = rs.getString(6);
				if(pswd.equalsIgnoreCase(password))
				{
				pw.println("<br><br><br><center><h3>  MY PERSONAL INFORMATION  </h3></center><br>");
				pw.println("<center><p>"+
				         "FirstName   ="+rs.getString("FirstName")+"<br><br>"
						+"LastName    =   "+rs.getString("Lastname")+"<br><br>"
						+ "Email      =   "+rs.getString("Email")+"<br><br>"
						+ "Gender     =   "+rs.getString("Gender")+"<br><br>"
						+ "LoginID    =   "+rs.getString("LoginID")+"<br><br>"
						+ "Password    =   "+rs.getString("Password")+"<br><br>"
						+ "Contact    =   "+rs.getString("Contact")+"<br><br>"
						+ "Address    =   "+rs.getString("Address")+"</p></center>"
						);
				resp=1;
				break;}
				else {
					resp=0;
				}
			}
			if(resp==0) {
				pw.println("<br><br><center><h3>Invalid Password !!!!....</h3></center>");
				pw.println("<br><br>"+"<center><h1>Your Attempt is Unsuccessfull  <span style='color: red; font-size:30px'>&#x274C;</span></h1></center> <br><br>");
				pw.println("<center><h4>Enter Your Password Once Again <p>&#128542;</p></h4>"
						+ "<br><br>Click here to --> <a href='profile.html'>Re-Enter-Password</a>"+" </center>");
			}
			
		} catch (Exception e) {
			pw.println(e);
		}
		
	}

}
