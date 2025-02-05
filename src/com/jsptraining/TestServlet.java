package com.jsptraining;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Define datasource/connection pool for Resource Injection
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Customer> customers = new ArrayList<>();
		// Step 1:  Set up the printwriter
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		// Step 2:  Get a connection to the database
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = ConnectionPool.getConnection();
			
			// Step 3:  Create a SQL statements
			String sql = "select * from customer";
			myStmt = myConn.createStatement();
			
			// Step 4:  Execute SQL query
			//added from remote repository
			myRs = myStmt.executeQuery(sql);
			//this line added for testing
			// Step 5:  Process the result set
			while (myRs.next()) {
				String city = myRs.getString("customer_city");
				String customerName=myRs.getString("customer_name");
				Boolean isPriviledged=myRs.getBoolean("isPrivileged");
				out.println(city+customerName+isPriviledged);
				Customer customer=new Customer(customerName,city,isPriviledged);
				customers.add(customer);
			}
			return customers;
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
