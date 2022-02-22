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
 * Servlet implementation class Creator
 */
@WebServlet("/Creator")
public class Creator extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	Connection conn;
	PreparedStatement stmt;
	
	public void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Akanksha02@");
			stmt=conn.prepareStatement("insert into emp values(?,?,?,?,?)");
		}catch(ClassNotFoundException e ){
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		int salary=Integer.parseInt(request.getParameter("salary"));
		String designation=request.getParameter("designation");
			try {
				
				stmt.setInt(1, id);
				stmt.setString(2, name);
				stmt.setInt(3, age);
				stmt.setInt(4, salary);
				stmt.setString(5, designation);
				int i = stmt.executeUpdate();
				if(i>=0) {
					out.print("User successfully inserted...");
					//out.println("<a href=\'index.html\'>Home</a>");
					//response.setAttribute()
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