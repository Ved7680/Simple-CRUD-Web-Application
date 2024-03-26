package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.print("<form action='InsertStudentServlet' method='get'>");
        out.print("	<input type='text' value='"+ (request.getAttribute("stdVal") == null ? "" : request.getAttribute("stdVal")) +"' name='sstd' id='std' placeholder='Enter Student Std'> "+ (request.getAttribute("stdErr") == null ? "" : request.getAttribute("stdErr")) +" <br><br>");
        out.print("	<input type='text' value='"+ (request.getAttribute("nameVal") == null ? "" : request.getAttribute("nameVal")) +"'name='sname' id='name' placeholder='Enter Student Name'> "+ ((request.getAttribute("nameErr") == null ? "" : request.getAttribute("nameErr"))) +" <br><br>");
        out.print("	<input type='text' value='"+ (request.getAttribute("marksVal") == null ? "" : request.getAttribute("marksVal")) +"' name='smarks' id='marks' placeholder='Enter Student Marks'> "+ ((request.getAttribute("marksErr") == null ? "" : request.getAttribute("marksErr"))) +" <br><br>");
        out.print("	<input type='submit' value='submit'>");
        out.print("</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
