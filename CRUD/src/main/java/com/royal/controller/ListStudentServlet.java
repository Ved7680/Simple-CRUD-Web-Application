package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		StudentDao dao = new StudentDao();
		
		ArrayList<StudentBean> list = dao.getAllRecords();
		
		out.print("<table border='1'>");
		out.print("	<tr>                ");
		out.print("		<td>Rno</td>     ");
		out.print("		<td>Name</td>    ");
		out.print("		<td>Std</td>     ");
		out.print("		<td>Marks</td>   ");
		out.print("		<td>ACTION</td>   ");
		out.print("	</tr>               ");
		
		for(int i=0; i<list.size(); i++)
		{
			StudentBean sbean = list.get(i);
			out.print("<tr>            ");
			out.print("		<td>"+sbean.getRoll_no()+"</td>        ");
			out.print("		<td>"+sbean.getName()+"</td>        ");
			out.print("		<td>"+sbean.getStd()+"</td>        ");
			out.print("		<td>"+sbean.getMarks()+"</td>        ");
			out.print("		<td><a  href='EditStudentServlet?rno="+sbean.getRoll_no()+"'>EDIT</a> | <a  href='DeleteStudentServlet?rno="+sbean.getRoll_no()+"'>DELETE</a></td>        ");
			out.print("	</tr>               ");
		}
		out.print("</table>				");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
