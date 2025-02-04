package com.jsptraining;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class customerControllerServlet
 */
@WebServlet("/CustomerControllerServlet")
public class CustomerControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerUtils customerUtils;
	
	Connection connection;

	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our customer db util ... and pass in the conn pool / datasource
		try {
			connection =ConnectionPool.getConnection();
			customerUtils= new CustomerUtils(connection);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// list the customers ... in mvc fashion
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing customers
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listCustomers(request, response);
				break;
			case "UPDATE":
				updateCustomer(request, response);
				break;
			case "ADD":
				addCustomer(request, response);
				break;
			case "DELETE":
				deleteCustomer(request, response);
				break;
			case "LOAD":
				loadCustomer(request, response);
				break;
				
			default:
				listCustomers(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
			
		
	}
	
	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

			// read customer id from form data
			String customername = request.getParameter("customername");
			
			// delete customer from database
			customerUtils.deleteCustomer(customername);
			
			// send them back to "list customers" page
			listCustomers(request, response);
		}


	private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

			// read customer info from form data
			
			String customerName = request.getParameter("customername");
			String city = request.getParameter("customercity");
			String isPrivileged = request.getParameter("isPrivileged");
			boolean isPrive=(isPrivileged!=null && isPrivileged.equals("true"))?true:false;
			// create a new customer object
			Customer theCustomer= new Customer(customerName,city,isPrive);
			
			// perform update on database
			customerUtils.updateCustomer(theCustomer);
			
			// send them back to the "list customers" page
			listCustomers(request, response);
			
		}

	private void listCustomers(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// get customers from db util
		List<Customer> customers = customerUtils.getCutomers();
//		response.getWriter().println(customers.size());
//		// add customers to the request
//		request.setAttribute("CUSTOMER_LIST", customers);
//				for(Customer customer:customers) {
//					response.getWriter().println(customer);
//				}
		// send to JSP page (view)
		request.setAttribute("CUSTOMER_LIST", customers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-customer.jsp");
		dispatcher.forward(request, response);
	}
	
	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read customer info from form data
		String customerName = request.getParameter("customername");
		String city = request.getParameter("city");
		String isPrivileged = request.getParameter("isPrivileged");		
		boolean isPrive=(isPrivileged!=null && isPrivileged.equals("true"))?true:false;
		// create a new customer object
		Customer theCustomer= new Customer(customerName, city, isPrive);
		
		// add the customer to the database
		customerUtils.addCustomer(theCustomer);				
		// send back to main page (the customer list)
		listCustomers(request, response);
	}




private void loadCustomer(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read customer id from form data
		String customername = request.getParameter("customername");
		
		// get customer from database (db util)
		Customer theCustomer = customerUtils.getCustomer(customername);
		
		// place customer in the request attribute
		request.setAttribute("THE_CUSTOMER", theCustomer);
		
		// send to jsp page: update-customer-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-customer-form.jsp");
		dispatcher.forward(request, response);		
}
}









