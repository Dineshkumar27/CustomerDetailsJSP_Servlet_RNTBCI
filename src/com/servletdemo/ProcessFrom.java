package com.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProcessFrom")
public class ProcessFrom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. Create a response type
		response.setContentType("text/html");
		
		//2. Create out object for printing
		PrintWriter out=response.getWriter();
		
		//3. Get the parameters from the Form
		
		String firstName=request.getParameter("firstname");
		String lastName=request.getParameter("lastname");
		
		out.println("<h1>User Submission Data</h1>");
		
		out.println("<h3>"+"Firstname: "+firstName+"</h3> <br/>");
		out.println("<h3>"+"Lastname: "+lastName+"</h3>  <br/>");
		
	}

	

}
