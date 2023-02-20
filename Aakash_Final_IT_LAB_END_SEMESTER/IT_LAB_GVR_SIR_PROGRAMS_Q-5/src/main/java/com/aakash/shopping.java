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

/**
 * Servlet implementation class shopping
 */
@WebServlet("/shopping")
public class shopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shopping() {
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
    
    public static void preview(HttpServletRequest request,HttpServletResponse response,Connection conn,String tb_name) throws IOException 
    {
    	response.setContentType("text/html");
    	PrintWriter pw = response.getWriter();
    	String textbook = request.getParameter("booklist");
		int  quantity = Integer.parseInt(request.getParameter("qnty"));
		try {
			
			PreparedStatement ps = conn.prepareStatement("select * from "+" "+tb_name+" "+"where BooksandMagazines = ?");
			ps.setString(1,textbook);
			ResultSet rs = ps.executeQuery();
	
			while(rs.next()) {
				String books = rs.getString(1);
                String author = rs.getString(2);
                String pub = rs.getString(3);
                int prc = rs.getInt(4);
				pw.println("<br><br><h2 align='center'>PREVIEW ORDER DETAILS</h2>");
				pw.println("<br> <p align='center'>"+" BookorMagazine = "+books+"</h3>");
				pw.println("<br> <p align='center'>"+" Author = "+author+"</h3>");
				pw.println("<br> <p align='center'>"+" Publication = "+pub+"</h3>");
				pw.println("<br> <p align='center'>"+" Quantity = "+quantity+"</h3>");
				pw.println("<br> <p align='center'>"+" Item-cost = "+prc+"</h3>");
				pw.println("<br> <p align='center'>"+" TotalAmount = "+quantity*prc+"</h3>");
			}
			
			pw.println("<br><br><br><a href = 'payment.html'><input type='submit' value = 'CONTINUE TO PAYMENT'></a>");
		}
		
		catch (Exception e) {
			pw.println(e);
		}
    	
    	
    }
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		response.setContentType("text/html"); 
		PrintWriter pw = response.getWriter();
		
		String database_name = "it_lab";
		String table_name = "book_catalogue";
		
		String create_table     = "CREATE TABLE "+" "+table_name+" "+"("
                +"BooksandMagazines CHAR(100) not null,"+"Author CHAR(50) not null,"
                +"Publication VARCHAR(50) not null,"+"Price Integer not null)";
		
//		" "+"(BookorMagazine,Author,Publication,Price)"+" "
		
		String insert_values = "Insert into "+" "+table_name+" "+"values"
		                        +"('The Complete Reference PC Hardware','Craig Zacker','McGraw Hill',265),"
		                        +"('Computer Hardware','Kevin Wilson','Elluminet Press',1268),"
		                        +"('Modern Computer Hardware','Manahar Lotia','BPB Publications',596),"
		                        +"('Java The Complete Reference','Herbert Schildt','McGraw Hill',1650),"
		                        +"('Automate the boring Stuff with Python','AI Sweigart','Nostarch',3589),"
		                        +"('Flutter and Dart Cookbook','Richard Rose','Shroff Publishers',1200),"
		                        +"('TimesNow','Malhotra','TimesNow',525),"
		                        +"('Forbes','Antonine Gara','Forbes',2587),"
		                        +"('NewYork Magazine','Jia Tolentino','Oscars',3025)"
				;
		
		
		
//		String insert_values = "Insert into "+" "+table_name+" "+"values ('The Complete Reference PC Hardware','Craig Zacker','McGraw Hill',265),('Computer Hardware','Kevin Wilson','Elluminet Press',1268),('Modern Computer Hardware','Manahar Lotia','BPB Publications',596),('Java The Complete Reference','Herbert Schildt','McGraw Hill',1650),('Automate the boring Stuff with Python','AI Sweigart','Nostarch',3589),('Flutter and Dart Cookbook','Richard Rose','Shroff Publishers',1200),('TimesNow','Malhotra','TimesNow',525),('Forbes','Antonine Gara','Forbes',2587),('NewYork Magazine','Jia Tolentino','Oscars',3025)";                                              
		
		
		
		
//		String textbook = request.getParameter("booklist");
//		int  quantity = Integer.parseInt(request.getParameter("qnty"));
		
		
		
		// jdbc connection
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8111"+"/"+database_name,"root","");
			Statement stmt = conn.createStatement();
			boolean tb_match = reg.Table_Match(conn,table_name,database_name);
			if(tb_match==false) {
				stmt.executeUpdate(create_table);
				stmt.executeUpdate(insert_values);
//				preview(request, response, conn, table_name);
//				pw.println("<br>Table Created Succesfully");
//				pw.println("<br>Values Inserted Succesfully");
//				pw.println("<br> Textbook You Selected is "+textbook);
//				pw.println("<br> Quantity = "+quantity);
			}
			else {
				preview(request, response, conn,table_name);
//				pw.println("<br>"+textbook);
//				pw.println("<br> Quantity = "+quantity);
			}
			
			
			
			
		} catch (Exception e) {
			pw.println(e);
		}
	}

}
