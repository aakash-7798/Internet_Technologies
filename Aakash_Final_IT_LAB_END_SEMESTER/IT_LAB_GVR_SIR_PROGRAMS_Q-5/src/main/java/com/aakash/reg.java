package com.aakash;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import org.apache.catalina.connector.Response;
import org.apache.jasper.tagplugins.jstl.core.Catch;
import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

import java.sql.*;
import java.util.jar.Attributes;

/**
 * Servlet implementation class reg
 */
@WebServlet("/reg")
public class reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reg() {
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
    
    
//      The following function is helpful in converting password to hash code so that no one can now what your password is except you.
    
    public static String convertToMD5Hash(String input) throws NoSuchAlgorithmException {
    	MessageDigest md = MessageDigest.getInstance("MD5");
    	md.update(input.getBytes());
    	byte[] digest = md.digest();
    	StringBuilder sb = new StringBuilder();
    	for(byte b:digest) {
    		sb.append(String.format("%02x",b & 0xff));
    	}
 		return sb.toString();
    }
    
    
    public static boolean Database_match (Connection conn,String db_name)
    {
        boolean flag=false;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("show databases");
            while(rs.next()){
                String database_name = rs.getString(1);
                if(database_name.equalsIgnoreCase(db_name)){
                    flag=true;break;}
                else{flag=false;}
            }
        }
        catch (Exception e){e.printStackTrace();}
        return flag;
    }
    
    public static boolean Table_Match(Connection conn,String tb_name,String db_name){
        boolean flag=false;
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("use"+" "+db_name);
            ResultSet rs = stmt.executeQuery("show tables");
            while (rs.next()){
                String tables = rs.getString(1);
//                System.out.println(tables);
                if(tables.equalsIgnoreCase(tb_name)){
                    flag=true;
                    break;
                }
                else{
                    flag=false;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    
    public static void result_status_success(HttpServletResponse response) throws IOException
    {
    	PrintWriter pw = response.getWriter();
    	pw.println("<br><br>"+"<center><h1>Your ReGistration is Successfull  <span style='color: green; font-size:30px'>&#x2713;</span></h1></center> <br><br>");
		pw.println("<center><h4>ThankYou For ReGisterinG<p>&#128512;</p></h4> "
				+ "<br><br>Click here to --> <a href='login.html'>Login </a> </center>");
    }
    public static void result_status_unsuccess(HttpServletResponse response) throws IOException
    {
    	PrintWriter pw = response.getWriter();
    	pw.println("<br><br>"+"<center><h1>Your ReGistration is Unsuccessfull  <span style='color: red; font-size:30px'>&#x274C;</span></h1></center> <br><br>");
		pw.println("<center><h4>ReGister Once Again <p>&#128542;</p></h4>"
				+ "<br><br>Click here to --> <a href='reg.html'>Register</a>"+" </center>");
    }


    
    public static void sendDataToServer(Connection conn ,String[] fa,String tb_name,HttpServletResponse response) throws IOException 
	{
    	PrintWriter pw = response.getWriter();
    	try {
    		PreparedStatement ps = conn.prepareStatement("insert into "+" "+tb_name +" "+"values(?,?,?,?,?,?,?,?)");
		ps.setString(1, fa[0]);
		ps.setString(2, fa[1]);
		ps.setString(3, fa[2]);
		ps.setString(4, fa[3]);
		ps.setString(5, fa[4]);
		ps.setString(6,fa[5]);
		ps.setString(7,fa[6]);
		ps.setString(8,fa[7]);
		int x = ps.executeUpdate();
		ps.close();
		if(x>0) {
	    result_status_success(response);
	    }
	    else {
	    	result_status_unsuccess(response);
	    }
		}
    	catch (Exception e) {
			pw.println(e);
		} 
		
	}
    public static boolean loginid_or_email_match(Connection conn,String db_name,String table_name,String[] fa){
        boolean flag=false;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs  = stmt.executeQuery("select Email,LoginId from "+" "+table_name);
            while (rs.next()){
                String email = rs.getString("Email");
                String loginId = rs.getString("LoginId");
                if(email.equalsIgnoreCase(fa[2]) || loginId.equalsIgnoreCase(fa[4])){
                    flag=true;
//                    System.out.println("Email or LoginId is already Existed");
                    break;
                }
                else{
//                    System.out.println("Your Record is unique");
                    flag=false;
                }

            }
        }
        catch (Exception e){e.printStackTrace();}
        return flag;
    }


    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
//		pw.println("<br><br>"+"<center><h1>Your ReGistration is Successfull  <span style='color: green; font-size:30px'>&#x2713;</span></h1></center> <br><br>");
//		pw.println("<center><h4>ThankYou For ReGisterinG<p>&#128512;</p></h4> </center>");
		
		String Firstname = request.getParameter("fname");
		String Lastname = request.getParameter("lname");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String loginid = request.getParameter("lgnid");
		String password = request.getParameter("pswd");
		
		try {
			password =  convertToMD5Hash(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} 
		String contact = request.getParameter("phno");
		String address = request.getParameter("address");
		
		
		String data[] = new String[] {Firstname,Lastname,email,gender,loginid,password,contact,address}; 
		
//		pw.println("<center><h3>Following are the details which you Entered  </h3></center><br>");
//		pw.println("<center><p>"+
//		         "FirstName   ="+Firstname+"<br><br>"
//				+"LastName    =   "+Lastname+"<br><br>"
//				+ "Email      =   "+email+"<br><br>"
//				+ "Gender     =   "+gender+"<br><br>"
//				+ "LoginID    =   "+loginid+"<br><br>"
//				+ "Password   =   "+password+"<br><br>"
//				+ "Contact    =   "+contact+"<br><br>"
//				+ "Address    =   "+address+"</p></center>"
//				);

//		Now we need to send the above data to server so that we can store them and retrieve them..
//		To perform above task we need to establish a connection to database
//		As I am using XAMPP server i will establish a connection to MySQL server
//		For the time being it is better to manually create a database called IT_LAB and some related tables in XAMPP MySQL  Server
//		It is possible to write the code but makes the code verbose and difficult to understand so better to follow above step
//		If you want to write code then go ahead no problem

		//  Following is JDBC Connection	 
		
	
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			"jdbc:mysql://localhost:8111/,"root",""   -> after localhost give the portnumber which appears after clicking mysql start in xampp control panel  (default is -> 3306)
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8111","root","");
			Statement stmt = conn.createStatement();
			
//			String Id_or_mail_match = "select Email,LoginId from registration_form";
			
			String database_name = "IT_LAB"; 
			String table_name = "registration_form";
			String create_database = "Create database"+" "+database_name;
			String use_database = " Use "+" "+database_name;
			String create_table     = "CREATE TABLE "+" "+table_name+" "+"("
                    +"FirstName CHAR(30) not null,"+"LastName CHAR(30) not null,"
                    +"Email VARCHAR(50) not null,"+"Gender CHAR(8) not null,"
                    +"LoginId VARCHAR(15) not null,"+"Password VARCHAR(50) not null,"
                    +"Contact VARCHAR(12) not null,"+"Address VARCHAR(20)"
                    + ")";

			boolean db_match_result = Database_match(conn,database_name);
            boolean tb_match_result = Table_Match(conn,table_name,database_name);
            boolean lgnid_email_match = loginid_or_email_match(conn,database_name,table_name,data);
            

            if(db_match_result==false){
                stmt.executeUpdate(create_database);
                stmt.executeUpdate(use_database);
                stmt.executeUpdate(create_table);
                sendDataToServer(conn,data,table_name,response);
            }
            else{
                conn = DriverManager.getConnection("jdbc:mysql://localhost:8111"+"/"+database_name,"root","");
                stmt = conn.createStatement();
                stmt.executeUpdate(use_database);
                if(tb_match_result==false){
                    stmt.executeUpdate(create_table);
                    sendDataToServer(conn,data,table_name,response);
                }
                else{
                    if(lgnid_email_match==false){
                    	sendDataToServer(conn,data,table_name,response);}
                    else{
                    	 pw.println("<br><br><center><h3>Email or LoginId is already Existed !!!!....</h3></center>");
                    	 result_status_unsuccess(response);
                    }
                }
            }
			
		}
		catch(Exception e){
			result_status_unsuccess(response);
			pw.println("<br>"+e.getMessage());
		}
		
		
	
	
	
	}

}
