package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.royal.bean.StudentBean;
import com.royal.util.DBConnection;

public class StudentDao {
	
	public int Insert(StudentBean sbean){
		// 1. Making Insert Query
		String insertQuery = "INSERT INTO student(Name,Std,Marks) VALUES(?,?,?);";
		
		// 2. Getting Database Connection
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		int rowsAffected = 0;
		
		// 3. Validating connection object
		if(conn != null)
		{
			// 4. Creating Prepared Statement
			try {
				pstmt = conn.prepareStatement(insertQuery);
				
				pstmt.setString(1, sbean.getName());
				pstmt.setInt(2, sbean.getStd());
				pstmt.setInt(3, sbean.getMarks());
				
				rowsAffected = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("DB not Connected -- "+conn);
		}
		
		return rowsAffected;
	}
	
	public int delete(int rno)
	{
		// 1. Making Insert Query
		String insertQuery = "DELETE FROM student WHERE Roll_No=?";
		
		// 2. Getting Database Connection
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		int rowsAffected = 0;
		
		// 3. Validating conn object
		if(conn != null)
		{
			// 4. Creating Prepared Statement
			try {
				pstmt = conn.prepareStatement(insertQuery);
				
				pstmt.setInt(1, rno);
				
				rowsAffected = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("DB not Connected -- "+conn);
		}
		return rowsAffected;
	}
	
	public static int update(StudentBean sbean)
	{
		// 1. Making Insert Query
		String insertQuery = "UPDATE student SET Name = ?, Std = ?, Marks=? WHERE Roll_No = ?";
		
		// 2. Getting Database Connection
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		int rowsAffected = 0;
		
		// 3. Validating conn object
		if(conn != null)
		{
			// 4. Creating Prepared Statement
			try {
				pstmt = conn.prepareStatement(insertQuery);
				
				pstmt.setString(1, sbean.getName());
				pstmt.setInt(2, sbean.getStd());
				pstmt.setInt(3, sbean.getRoll_no());
				pstmt.setInt(4, sbean.getMarks());
				
				rowsAffected = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("DB not Connected -- "+conn);
		}
		return rowsAffected;
	}
	
	public static StudentBean getStudentById(int id)
	{
//		int rowsAffected = 0;
		StudentBean sbean = new StudentBean();
		
		// 1. Making ID Query
		String idQuery = "SELECT * FROM student WHERE Roll_No=?";
		
		// 2. Getting Connection
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		
		// 3. Validating conn Object
		if (conn != null)
		{
			try {
				pstmt = conn.prepareStatement(idQuery);
				
				pstmt.setInt(1, id);
//				rowsAffected = pstmt.executeUpdate();
				ResultSet rs= pstmt.executeQuery();  
	            if(rs.next()){  
	            	sbean.setRoll_no(rs.getInt(1));  
	                sbean.setName(rs.getString(2));  
	                sbean.setStd(rs.getInt(3));
	                sbean.setMarks(rs.getInt(4));
		        }  
		        conn.close(); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return sbean;
	}
	
	public ArrayList<StudentBean> getAllRecords()
	{
		// Result Set is used to store data from database into Java Program
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		StudentBean sbean= null;
		ArrayList<StudentBean> lists = new ArrayList<StudentBean>();
		
		
		// 1. Making a get all records query
		String allQuery = "SELECT * FROM student";
		
		// 2. Getting DB Connection
		Connection conn = DBConnection.getConnection();
		
		// 3. Validating Conn Object
		if (conn!=null)
		{
			// 4. Preparing Statement
			try {
				pstmt = conn.prepareStatement(allQuery);
				
				rs = pstmt.executeQuery(allQuery);
				while(rs.next())
				{
					int rno = rs.getInt(1);
					String name = rs.getString(2);
					int std = rs.getInt(3);
					int marks = rs.getInt(4);
					
					sbean = new StudentBean(name, std, rno, marks);
					
					lists.add(sbean);
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("getAllRecords() -- DB Not Connected");
		}
		return lists;
	}
	
//	public static void main(String[] args) {
//		StudentDao dao = new StudentDao();
//		StudentBean s = dao.getStudentById(1);
//		
//		System.out.println("Name: "+s.getName()+", Marks: "+s.getMarks());
//	}
}
