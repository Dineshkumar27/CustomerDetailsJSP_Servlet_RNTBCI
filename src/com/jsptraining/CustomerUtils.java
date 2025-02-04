package com.jsptraining;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class CustomerUtils {
	private Connection connection;
	
	public CustomerUtils(Connection connection) {
		super();
		this.connection = connection;
		
	}

	public  List<Customer> getCutomers() throws Exception{
		List<Customer> customerList=new ArrayList<>();
		
		

//		customerList.add(new Customer("Rajan","Chennai",false));
//		customerList.add(new Customer("Vishnu","Hyderabad",false));
//		customerList.add(new Customer("Mukund","Vizag",true));
//		customerList.add(new Customer("Kalai","Chennai",true));
//		customerList.add(new Customer("Banu","Delhi",false));
		

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = ConnectionPool.getConnection();
			
			// create sql statement
			String sql = "select * from customers order by customer_name";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				
				String customerName = myRs.getString("customer_name");
				String customerCity = myRs.getString("customer_city");
				boolean isPrivileged = myRs.getBoolean("isPrivileged");
				
				// te new customer object
				 Customer customer = new Customer(customerName, customerCity, isPrivileged);
				
				// add it to the list of students
				 customerList.add(customer);				
			}
			
			return customerList;		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		
	}
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public void addCustomer(Customer theCustomer) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = ConnectionPool.getConnection();
			
			// create sql for insert
			String sql = "insert into customers "
					   + "(customer_name, customer_city, isPrivileged) "
					   + "values (?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setString(1, theCustomer.getCustomerName());
			myStmt.setString(2, theCustomer.getCustomerCity());
			myStmt.setBoolean(3, theCustomer.isPrivileged());
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}
public void updateCustomer(Customer theCustomer) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = ConnectionPool.getConnection();
			
			// create SQL update statement
			String sql = "update customers "
						+ "set customer_name=?, customer_city=?, isPrivileged=? "
						+ "where customer_name=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, theCustomer.getCustomerName());
			myStmt.setString(2, theCustomer.getCustomerCity());
			myStmt.setBoolean(3, theCustomer.isPrivileged());
			myStmt.setString(4, theCustomer.getCustomerName());
			
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

public Customer getCustomer(String customername) throws Exception {

	
	
	Connection myConn = null;
	PreparedStatement myStmt = null;
	ResultSet myRs = null;
	
	Customer customer;
	try {
	
		// get connection to database
		myConn = ConnectionPool.getConnection();
		
		// create sql to get selected customer
		String sql = "select * from customers where customer_name=?";
		
		// create prepared statement
		myStmt = myConn.prepareStatement(sql);
		
		// set params
		myStmt.setString(1, customername);
		
		// execute statement
		myRs = myStmt.executeQuery();
		
		// retrieve data from result set row
		if (myRs.next()) {
			String customerName = myRs.getString("customer_name");
			String customerCity = myRs.getString("customer_city");
			boolean isPrivileged = myRs.getBoolean("isPrivileged");
			
			// use the customername during construction
			customer = new Customer(customerName, customerCity, isPrivileged);
		}
		else {
			throw new Exception("Could not find customer id: " + customername);
		}				
		
		return customer;
	}
	finally {
		// clean up JDBC objects
		close(myConn, myStmt, myRs);
	}
}


public void deleteCustomer(String customername) throws Exception {

	Connection myConn = null;
	PreparedStatement myStmt = null;
	
	try {
		// get connection to database
		myConn = ConnectionPool.getConnection();
		
		// create sql to delete student
		String sql = "delete from customers where customer_name=?";
		
		// prepare statement
		myStmt = myConn.prepareStatement(sql);
		
		// set params
		myStmt.setString(1, customername);
		
		// execute sql statement
		myStmt.execute();
	}
	finally {
		// clean up JDBC code
		close(myConn, myStmt, null);
	}	
}
}

