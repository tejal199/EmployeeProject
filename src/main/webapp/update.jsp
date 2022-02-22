<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%! String driverName = "com.mysql.cj.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3306/mydb";%>
<%!String user = "root";%>
<%!String psw = "Akanksha02@";%>
<title>Update</title>
</head>
<body>
<div align="center">
<form method="post"><br/>
<table style="width: 80%">
<tr>
<td>Id</td>
<td><input type="text" name="id"/></td>
</tr>
<tr>
<td>SALARY</td>
<td><input type="text" name="salary"/></td>
</tr>
</table>
<input type="submit" value="Update">
</form>
</div>
<a href="index.html">Home</a>
</body>
</html>

<%
String id = request.getParameter("id");
String salary=request.getParameter("salary");

if(id != null)
{
Connection con = null;
PreparedStatement ps = null;
int personID = Integer.parseInt(id);
try
{
Class.forName(driverName);
con = DriverManager.getConnection(url,user,psw);
String sql="Update emp set id=?,salary=? where id="+id;
ps = con.prepareStatement(sql);
ps.setString(1,id);
ps.setString(2,salary);
int i = ps.executeUpdate();
if(i > 0)
{
out.print("Record Updated Successfully");
}
else
{
out.print("There is a problem in updating Record.");
}
}
catch(SQLException sql)
{
request.setAttribute("error", sql);
out.println(sql);
}
}
%>