<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.*"%>
<%@page import=" java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import=" java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="domain.Product"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Cart</title>
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
	HttpSession track = request.getSession(false);
	ArrayList<Product> lt = (ArrayList<Product>) session.getAttribute("cart");
	%>
	<div class="left">
		<a>
			<%out.print(session.getAttribute("username")); %>
		</a> <a href="HomeProductPage.jsp"> Home </a> <a href="ViewProfile.jsp">
			View User Profile </a> <a href="checkout.do"> Check OUt </a> <a
			href="logout.do"> Log OUT </a>
		<h1>Cart</h1>
	</div>
	<Table class="center">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>price</th>
			<th>Category</th>
			<th>Units</th>
		</tr>
		<%
		Iterator<Product> it;
		if(lt != null){
		 it = lt.iterator();
		 
		while (it.hasNext()) {
			Product Current = it.next();
		%>
		<tr>
			<td>
				<%
				out.print(Current.getId());
				%>
			</td>
			<td>
				<%
				out.print(Current.getName());
				%>
			</td>
			<td>
				<%
				out.print(Current.getPrice());
				%>
			</td>
			<td>
				<%
				out.print(Current.getCategory());
				%>
			</td>
			<td>
				<%
				out.print(Current.getUnitsInStock());
				%>
			</td>
			<td><a
				href="deletefromcart.do?id=<%out.print(Current.getId());%>">delete
					from cart</a></td>
		</tr>
		<%
		}}
		%>


	</Table>
</body>
</html>