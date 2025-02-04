package com.jsptraining;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Testservelt2
 */
@WebServlet("/Testservelt2")
public class Testservelt2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Testservelt2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String url
        = "jdbc:mysql://localhost:3306/customedb"; // table details
    String username = "webstudent"; // MySQL credentials
    String password = "webstudent";
    String query
        = "select *from customers"; // query to be run
    try {
		Class.forName(
		    "com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} // Driver name
    try {
		Connection myConn = DriverManager.getConnection(
		    url, username, password);
		response.getWriter().println("Connection done");
		Statement myStmt = null;
		ResultSet myRs = null;
			
			
			// Step 3:  Create a SQL statements
			String sql = "select * from customers";
			myStmt = myConn.createStatement();
			
			// Step 4:  Execute SQL query
			myRs = myStmt.executeQuery(sql);
			
			// Step 5:  Process the result set
			while (myRs.next()) {
				String email = myRs.getString("customer_name");
				response.getWriter().println(email);
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	
}
