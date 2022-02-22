package com.tj;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection conn;
	PreparedStatement stmt;
	
	public void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Akanksha02@");
			stmt=conn.prepareStatement("delete from emp where id =?");
		}catch(ClassNotFoundException e ){
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		int id=Integer.parseInt(request.getParameter("id"));
			try {
				
				stmt.setInt(1, id);
				int i = stmt.executeUpdate();
				if(i>0) {
					out.println("User successfully deleted.....");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
	  }catch(NullPointerException e)	{
		  e.printStackTrace();
	  }
			out.println("<a href=\"index.html\">Home</a>");
}		

		 		
			public void destroy() {
				
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			}
}