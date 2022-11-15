<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="view" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>ABP Electronics</title>
<style>
.table {
	width: 75%;
	margin-left:22%
}
h1{
   color:black;
   margin-top: 7%;
   margin-left:44%;
   text-size:18px;
}
</style>
</head>
<body>
<%@include file="SellerAdmin.jsp"%>
	<h1>
		Product Details &nbsp;<a href="addproduct"><button style="width:15%;">Add</button></a>
	</h1>
	<br>
	<table class="table table-hover table-dark" border="1" rules="all">
		<thead>
			<tr>
			   
				<th>Company Name</th>
				<th>CategoryName</th>
				<th>Product Id</th>
				<th>Product Name</th>
				<th>Product Description</th>
				<th>Product Price</th>
				<th>Product Image</th>
				<th colspan="2" style="text-align: center;">Action</th>
			</tr>
		</thead>
		<view:forEach var="details" items="${products}">
				<tr>
					<td>${details.getCompName()}</td>
					<td>${details.getCateName()}</td>
					<td>${details.getProcId()}</td>
					<td>${details.getProcName()}</td>	
					<td>${details.getDescription()}</td>	
					<td>${details.getPrice()}</td>	
					
					<td><img src="data:images/jpg;base64,${details.getImage()}" style="width: 150px;height: 130px;"></td>		
					<td><a href="">Edit</a></td>
					<td><a href='delete/${details.getId()}'>Delete</a>
				
					</td>	
				</tr>
			</view:forEach>
	</table>
</body>
</html>