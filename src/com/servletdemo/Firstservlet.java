package com.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsptraining.Customer;

/**
 * Servlet implementation class Firstservlet
 */
@WebServlet("/Firstservlet2")
public class Firstservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1> Welcome to Servlet</h1>");
		out.println("</body>");
		out.println("</html>");
		List<Customer> customers=new ArrayList<>();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_db", "root", "admin123");
	        out.println(
	            "Connection Established successfully");
//	        Statement st = con.createStatement();
//	        ResultSet rs
//            = st.executeQuery("select * from employee"); // Execute query
//        while(rs.next()) {
//            out.print(rs.getString(1)+" "+rs.getString(2));
//        }
	       
		} catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Driver name
	        
	       
	}
	

}
