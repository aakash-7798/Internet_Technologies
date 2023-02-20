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
 * Servlet implementation class payment
 */
@WebServlet("/payment")
public class payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payment() {
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
    public static void result_status_success(HttpServletResponse response) throws IOException
    {
    	PrintWriter pw = response.getWriter();
    	pw.println("<br><br>"+"<center><h1>\r\n"
    			+ "    AAKASH ONLINE BOOK STORAGE\r\n"
    			+ "  </h1><br><br><h1>Your Payment is Successfull  <span style='color: green; font-size:30px'>&#x2713;</span></h1></center> <br><br>");
		pw.println("<center><h4>ThankYou For Choosing Aakash Book Store<p>&#128512;</p></h4> "
				+ "<pre>\r\n"
				+ "    <strong>\r\n"
				+ "      <h2>THANK YOU </h2>\r\n"
				+ "      <h2> Visit Again</h2>\r\n"
				+ "    </strong>\r\n"
				+ "  </pre>"
				+  "</center>");
    }
    public static void result_status_unsuccess(HttpServletResponse response) throws IOException
    {
    	PrintWriter pw = response.getWriter();
    	pw.println("<br><br>"+"<center><h1>\r\n"
    			+ "    AAKASH ONLINE BOOK STORAGE\r\n"
    			+ "  </h1><br><br><h1>Your Payment is Unsuccessfull  <span style='color: red; font-size:30px'>&#x274C;</span></h1></center> <br><br>");
		pw.println("<center><h4>Order once Again <p>&#128542;</p></h4>"
				+ "<br><br>Click here to --> <a href='shoppingcart.html'>Order Once Again</a>"+" </center>");
    }

    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
    	
    	
    	response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String creditcardnumber = request.getParameter("crdcd");
//		 
		
		String password = request.getParameter("pswd");
		
//		Below reg java file is available in aakash package
//		Making use of already created function in that package
		try {
			password = reg.convertToMD5Hash(password);
		} catch (Exception e) {
			pw.println(e);
		}
		
//		JDBC connection
		try {
			String database_name = "it_lab";
            String tb_name = "registration_form";
			
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8111"+"/"+database_name,"root","");
			
//            PreparedStatement ps = conn.prepareStatement("select * from "+" "+tb_name+" "+"where Contact = ?");
            Statement stmt = conn.createStatement();
//            ps.setString(1,creditcardnumber.substring(0,11));
            ResultSet rs = stmt.executeQuery("select * from "+" "+tb_name);
//           
            boolean flag = false;
            while(rs.next()){
            	String psswd = rs.getString(6);
                String phno = rs.getString(7);
                String crdnbr = phno+phno.substring(4,10);
//                pw.print(crdnbr);
                if(creditcardnumber.equalsIgnoreCase(crdnbr) && password.equalsIgnoreCase(psswd))
                {
                	flag=true;
                	
                	break;
                }
                else {
               flag=false;
                }
            }
            if(flag==true)
            {result_status_success(response);}
            else {result_status_unsuccess(response);}
            
		} catch (Exception e) {
			pw.println(e);
		}
	}

}
