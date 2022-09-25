<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="dao.CustomerDAO"%>
<%@page import="domain.Customer"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Customer</title>
<style>
html, body {
	width: 100%;
	height: 100%;
	text-align: center;
	color: #000 !important;
	background-color: #edfdff !important;
}

text {
	color: #ffc107 !important
}

div {
	margin: auto;
	width: 600px;
}

table, th, td, form, h1 {
	padding: 10px;
	color: #ffc107 !important;
	font-family: Arial, Helvetica, sans-serif;
}

.center {
	margin-left: auto;
	margin-right: auto;
	padding: 10px;
}

a {
	display: inline;
	width: 10%;
	height: 10%;
	text-decoration: none;
	padding: 5px;
	border-radius: 5px;
	border: 1px white;
	transition-duration: 0.5s;
	margin-right: 10px;
	padding: 10px 10px 10px;
	color: #ffc107 !important;
	font-family: Arial, Helvetica, sans-serif;
}

a:hover {
	color: #fff !important;
	background-color: #00bcd4 !important;
	border: 1px solid white
}

div.left {
	color: #ffc107 !important;
	padding: 2px;
	margin-left: 5px;
	margin-right: 25px;
	width: 100%;
	height: 15%;
	background-color: #00bcd4 !important;
}
</style>
</head>
<body>
<body>
	<%
	CustomerDAO dao = new CustomerDAO();
	ArrayList<Customer> list;
	list = dao.getAllCustomers();
	Iterator<Customer> it = list.iterator();
	Customer current;
	%>
	<div class="left">
		<a>
			<%out.print(session.getAttribute("username")); %>
		</a> <a href="HomeProduct.html"> Home </a> <a href="logout.do"> Log
			OUt </a> <a href="ShowAllProducts.jsp">Show all Products</a> <a
			href="addaproduct.html">Add a Product</a> <a href="DeleteProduct.jsp">Delete
			A Product</a> <a href="ShowAllCustomers.jsp">Show all Customers</a> <a
			href="UpdateCustomer.jsp">Update A Customer </a>
		<h1>Update Customer</h1>
	</div>
	<table class="center">
		<tr>
			<th>ID</th>
			<th>USERNAME</th>
			<th>First name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Email</th>
		</tr>
		<%
		while (it.hasNext()) {
		%>
		<%
		current = it.next();
		%>
		<tr>
			<form method="post" action="updatecustomer.do">
				<td><input name="customerid" type="text"
					value=<%
				out.print(current.getCoustomerid());
				%>>

				</td>
				<td><input name="username" type="text"
					value=<%
				out.print(current.getUsername());
				%>></td>
				<td><input name="pass" type="text"
					value=<%
				out.print(current.getPass());
				%>></td>
				<td><input name="fname" type="text"
					value=<%
				out.print(current.getFname());
				%>></td>
				<td><input name="lname" type="text"
					value=<%
				out.print(current.getLname());
				%>></td>
				<td><input name="age" type="text"
					value=<%
				out.print(current.getAge());
				%>></td>
				<td><input name="email" type="text"
					value=<%
				out.print(current.getEmail());
				%>></td>
				<td><input type="submit" value="Update Customer"></td>
			</form>
		</tr>
		<%
		}
		%>
	
</body>
</html>