<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Creation</title>
</head>
<body>
<h3>Enter the Data: </h3>
<div align="center">
<form action="Creator" method="post"><br/>
<table style="width: 80%">
<tr>
<td>Id</td> 
<td><input type="text" name="id"/></td>
</tr>
<tr>
<td>Name</td>
<td><input type="text" name="name"/></td>
</tr>
<tr>
<td>Age</td>
<td><input type="text" name="age"/></td>
</tr>
<tr>
<td>Salary</td>
<td><input type="text" name="salary"/></td>
</tr>
<tr>
<td>Designation</td>
<td><input type="text" name="designation"/></td>
</tr>
</table>
<input type="submit" value="Register" />
</form>
</div>
</body>
</html>