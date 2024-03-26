package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditStudentServlet
 */
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		int rno = Integer.parseInt(request.getParameter("rno"));
		
		StudentDao sdao = new StudentDao();
		
		StudentBean sbean = sdao.getStudentById(rno);
		
		RequestDispatcher rd = null;
		
		if (sbean!=null)
		{
			out.print("<form action='UpdateStudentServlet'>                         ");
			out.print("	<table>                                                     ");
			out.print("			<tr>                                                ");
			out.print("			<td><h2>Student Registration Page </h2></td>        ");
			out.print("			<td></td>                                           ");
			out.print("		</tr>                                                   ");
			out.print("		<tr>                                                    ");
			out.print("			<td>Rno : </td>                                    ");
			out.print("			<td><input type='text' name='rno' value='"+sbean.getRoll_no()+"' readonly></td>           ");
			out.print("		</tr>                                                   ");

			out.print("		<tr>                                                    ");
			out.print("			<td>Name : </td>                                    ");
			out.print("			<td><input type='text' name='name' value='"+sbean.getName()+"'></td>           ");
			out.print("		</tr>                                                   ");
			out.print("		<tr>                                                    ");
			out.print("			<td>Std : </td>                                     ");
			out.print("			<td><input type='text' name='std'  value='"+sbean.getStd()+"'></td>            ");
			out.print("		</tr>S                                                  ");
			out.print("		<tr>                                                    ");
			out.print("			<td>Marks : </td>                                   ");
			out.print("			<td><input type='text' name='marks' value='"+sbean.getMarks()+"'></td>          ");
			out.print("		</tr>                                                   ");
			out.print("		<tr>                                                    ");
			out.print("			<td> </td>                                          ");
			out.print("			<td><input type='submit'></td>                     ");
			out.print("		</tr>                                                   ");
			out.print("	</table>                                                    ");
			out.print("</form>														");
		}
		else {
			rd = request.getRequestDispatcher("ListStudentServlet");
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
