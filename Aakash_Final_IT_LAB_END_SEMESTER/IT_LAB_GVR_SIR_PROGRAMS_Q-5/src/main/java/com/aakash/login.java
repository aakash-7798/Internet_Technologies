package com.aakash;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.aakash.reg;
import org.apache.jasper.tagplugins.jstl.core.Import;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
    
    public static String[] loginId_Password_Check(Connection conn ,String ld,String pd) {
    	String flag = "0";
    	String fname = null;
    	String lname = null;
    	try {
    	Statement stmt = conn.createStatement();
		ResultSet rs   =  stmt.executeQuery("select FirstName,LastName,LoginId,Password from registration_form");
		while(rs.next()) {
			fname = rs.getString("FirstName");
			lname = rs.getString("LastName");
			String lid = rs.getString("LoginId");
//			 Following Password is server data
			String pswd = rs.getString("Password");
			
			if(ld.equalsIgnoreCase(lid) && pd.equalsIgnoreCase(pswd))
			{
				flag = "1";
				break;}
			else{flag="0";}
			
		}
		}
    	catch (Exception e) {
			e.printStackTrace();
		}
    	return new String[] {flag,fname,lname};
    }
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setContentType("text/html");
		String database_name = "it_lab";
		PrintWriter pw = response.getWriter();
		String loginid = request.getParameter("lgnid");
		
//		  The Following Function convertToMD5Hash is from reg.java file while i have created for registration 
//		   So I have imported that file and making use of that static function;
		String password = request.getParameter("pswd");
		try {
			password = reg.convertToMD5Hash(password);
		} catch (Exception e) {
			pw.println(e);
		}
		
		
		
//		 Establish JDBC Connection to check the loginId and password is existed in database
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8111/"+database_name,"root","");
			String[] login_password_result = loginId_Password_Check(conn, loginid, password); 
			if(login_password_result[0]=="1") {
				pw.println("<br><br><br><h1 align=\"center\">AAKASH ONLINE BOOK STORAGE </h1>");
			pw.println("<br><br><center><h2> Welcome "+login_password_result[1]+" "+login_password_result[2]+" </h2></center>");
			pw.println("<br><br><center><a href = 'aakashbookstore.html'><input type='submit' value='CONTINUE TO DASHBOARD'></center>");
//			pw.println("<br><br><a href = 'catalouge.html'>BOOKS-CATALOGUE");
//			pw.println("<br><br><a href = 'order.html'>ORDER-CONFIRMATION");
			}
			else {
				pw.println("<br><br><center><h3>InvalidID or Password  !!!!....</h3></center>");
				pw.println("<br><br>"+"<center><h1>Your Login is Unsuccessfull  <span style='color: red; font-size:30px'>&#x274C;</span></h1></center> <br><br>");
				pw.println("<center><h4>Login Once Again <p>&#128542;</p></h4>"
						+ "<br><br>Click here to --> <a href='login.html'>Login</a>"+" </center>");
			}
		} catch (Exception e) {
			pw.println("<br><br><center><h3>InvalidID or Password  !!!!....</h3></center>");
			pw.println("<br><br>"+"<center><h1>Your Login is Unsuccessfull  <span style='color: red; font-size:30px'>&#x274C;</span></h1></center> <br><br>");
			pw.println("<center><h4>Login Once Again <p>&#128542;</p></h4>"
					+ "<br><br>Click here to --> <a href='login.html'>Login</a>"+" </center>");
//			pw.println(e.getMessage());
		}
	}

}
