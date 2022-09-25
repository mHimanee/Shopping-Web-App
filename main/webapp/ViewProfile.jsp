<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="dao.CustomerDAO"%>
<%@page import="domain.Customer"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Profile</title>
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

table, th, td, form {
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

h1 {
	color: #ffc107 !important;
	font-family: Arial, Helvetica, sans-serif;
}
</style>

</head>
<body>
	<%
	CustomerDAO dao = new CustomerDAO();
	ArrayList<Customer> list;
	list = dao.getAllCustomers();
	Customer current = dao.getCustomerById((String)session.getAttribute("customerid"));
	%>
	<div class="left">
		<a> <%
 out.print(session.getAttribute("username"));
 %></a> </a> <a href="HomeProductPage.jsp"> Home </a> <a href="logout.do">
			Log OUT </a>
		<div>
			<h1>
				<%out.print(session.getAttribute("username"));%>'s Floral Shoppe
				Profile
			</h1>

			<form method="post" action="updatec.do">
				<label>UserName:</label> <input type="text" id="username"
					name="username" value=<%out.print(current.getUsername());%>><br>
				<br> <label>Password:</label> <input type="password" id="pass"
					name="pass" value=<%out.print(current.getPass());%>><br>
				<br> <label>First Name</label> <input type="text" id="fname"
					name="fname" value=<%out.print(current.getFname());%>><br>
				<br> <label>Last Name</label> <input type="text" id="lname"
					name="lname" value=<%out.print(current.getLname());%>><br>
				<br> <label>age</label> <input type="text" id="age" name="age"
					value=<%out.print(current.getAge());%>><br> <br>
				<label>E-mail</label> <input type="text" id="email" name="email"
					value=<%out.print(current.getEmail());%>><br> <br>
				<input type="submit" value="Update">
			</form>
		</div>
</body>
</html>