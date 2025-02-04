package com.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsptraining.Customer;
import com.jsptraining.CustomerUtils;

/**
 * Servlet implementation class ReadArrayElements
 */
@WebServlet("/ReadArrayElements")
public class ReadArrayElements extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name[]= {"Jagan","Hari","Rajasekar"};
	
//	CustomerUtils customerUtils=new CustomerUtils();
//	List<Customer> customers=customerUtils.getCutomers();
//	//the attribute 'friends' will be access in jsp fil(myview.jsp)
//	  request.setAttribute("customers", customers);
		//1. Create a response type
		response.setContentType("text/html");
		
		//2. Create out object for printing
		PrintWriter out=response.getWriter();
	
		
		//to move the data 'customers' from servlet to View.jsp
		RequestDispatcher dispathcer=request.getRequestDispatcher("/myview.jsp");
		dispathcer.forward(request, response);
		
		
		
	}

  
}
