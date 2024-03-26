package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateStudentServlet
 */
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rno =Integer.parseInt(request.getParameter("rno"));
		String name = request.getParameter("name");
		String temp_std   =request.getParameter("std");
		String temp_marks =request.getParameter("marks");
		
		StudentBean sbean = new StudentBean();
		
		boolean flag = false;
   		
   		if((name.trim().length() > 0) && (name != null))
   		{
   			sbean.setName(name);
   			request.setAttribute("nameVal", name);
   		} else{
   			flag = true;
   			request.setAttribute("nameErr", "<font color='red'>Please Enter valid name</font>");
   		}
   		if((temp_std.trim().length() > 0) && (temp_std != null))
   		{
   			int std = Integer.parseInt(temp_std);
   			sbean.setStd(std);
   			request.setAttribute("stdVal", std);
   		} else{
   			flag = true;
   			request.setAttribute("stdErr", "<font color='red'>Please Enter valid Standard</font>");
   		}
   		if((temp_marks.trim().length() > 0) && (temp_marks != null))
   		{
   			int marks = Integer.parseInt(temp_marks);
   			sbean.setStd(marks);
   			request.setAttribute("marksVal", marks);
   		} else{
   			flag = true;
   			request.setAttribute("marksErr", "<font color='red'>Please Enter valid Marks</font>");
   		}
   		
   		RequestDispatcher rd = null;
   		
   		if (flag)
   		{
   			request.getRequestDispatcher("StudentRegistrationServlet").forward(request, response);
   		}
   		else
   		{
   	   		StudentDao dao = new StudentDao();
   			int rowsAffected = dao.update(sbean);
   	   		
   	   		if (rowsAffected > 0)
   	   		{
   	   			rd = request.getRequestDispatcher("ListStudentServlet");
   	   		}
   	   		else {
   	   			rd = request.getRequestDispatcher("CRUD_Insert.html");
   	   		}
   	   		rd.forward(request, response);
   		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
