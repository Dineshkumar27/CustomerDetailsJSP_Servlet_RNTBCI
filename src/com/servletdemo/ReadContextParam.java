package com.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadContextParam
 */
@WebServlet("/ReadContextParam")
public class ReadContextParam extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context=getServletContext();
		PrintWriter out = response.getWriter();
		out.println("Maximum Trainees in a batch: "+context.getInitParameter("max-number-of-trainees"));
		out.println("Batch Name: "+context.getInitParameter("name-of-training"));
	}
	}

	

