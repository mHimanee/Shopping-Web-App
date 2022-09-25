<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="dao.CustomerDAO"%>
<%@page import="domain.Customer"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show All Customer</title>
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
	width: 500px;
}

table, th, td, h1 {
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
	color: grey;
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
		<h1>Show All Customers</h1>
	</div>

	<table class="center">
		<tr>
			<th>ID</th>
			<th>USERNAME</th>
			<th>Pass</th>
			<th>First name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Email</th>
			<th>delete
			<th>
		</tr>
		<%
		while (it.hasNext()) {
		%>
		<%
		current = it.next();
		%>
		<tr>
			<td>
				<%
				out.print(current.getCoustomerid());
				%>
			</td>
			<td>
				<%
				out.print(current.getUsername());
				%>
			</td>
			<td>
				<%
				out.print(current.getPass());
				%>
			</td>
			<td>
				<%
				out.print(current.getFname());
				%>
			</td>
			<td>
				<%
				out.print(current.getLname());
				%>
			</td>
			<td>
				<%
				out.print(current.getAge());
				%>
			</td>
			<td>
				<%
				out.print(current.getEmail());
				%>
			</td>
			<td><a
				href="deletecustomer.do?id=<%out.print(current.getCoustomerid());%>">Delete
					Customer</a></td>
		</tr>
		<%
		}
		%>

	</table>



</body>
</html>