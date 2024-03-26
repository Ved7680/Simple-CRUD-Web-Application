package com.royal.controller;

import java.io.IOException;

import com.royal.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDao sdao = new StudentDao();
		int roll_no = Integer.parseInt(request.getParameter("rno"));
		
		int rowsAffected = sdao.delete(roll_no);
		
		RequestDispatcher rd = null;
		
		if(rowsAffected > 0) 
		{
			rd = request.getRequestDispatcher("ListStudentServlet");
		}else 
		{
			rd = request.getRequestDispatcher("CRUD_Insert.html");

		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
