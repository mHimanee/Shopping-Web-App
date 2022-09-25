<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="dao.ProductDataObject"%>
<%@page import="domain.Product"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Product</title>
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
	<div class="left">
		<a>
			<%out.print(session.getAttribute("username")); %>
		</a> <a href="HomeProduct.html"> Home </a> <a href="logout.do"> Log
			OUt </a> <a href="ShowAllProducts.jsp">Show all Products</a> <a
			href="addaproduct.html">Add a Product</a> <a href="DeleteProduct.jsp">Delete
			A Product</a> <a href="ShowAllCustomers.jsp">Show all Customers</a> <a
			href="UpdateCustomer.jsp">Update A Customer </a>
		<h1>Update Product</h1>
	</div>

	<table class="center">
		<%

		%>

		<%%>
		<%
		Product current;
		%>
		<%
		ProductDataObject dao = new ProductDataObject();
		%>
		<%
		ArrayList<Product> list = dao.getAllProducts();
		%>
		<%
		Iterator<Product> it = list.iterator();
		%>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>Price</th>
			<th>Units</th>
			<th>Category</th>
		</tr>
		<%
		while (it.hasNext()) {
		%>
		<%
		current = it.next();
		%>
		<tr>
			<form method="post" action="updateproduct.do">
				<td><input name="id" type="text"
					value=<%
				out.print(current.getId());
				%>></td>
				<td><input name="name" type="text"
					value=<%
				out.print(current.getName());
				%>></td>
				<td><input name="price" type="text"
					value=<%
				out.print(current.getPrice());
				%>></td>
				<td><input name="units" type="text"
					value=<%
				out.print(current.getUnitsInStock());
				%>>

				</td>
				<td><select name="category">
						<option>
							<%
				out.print(current.getCategory());
				%>
						</option>
						<option>Home and Kitchen</option>
						<option>tool</option>
						<option>personal</option>
						<option>electronics</option>
				</select></td>
				<td><input type="submit" value="Update Product"></td>
			</form>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>