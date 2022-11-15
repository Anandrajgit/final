<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="value" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="details" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ABP Electronics</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<style>
form {
	text-align: center;
	width: 28%;
}

#body {
	text-align: center;
	padding-left: 600px;
	padding-top: 0.5%;
}

h2 {
	text-align: center;
	padding-top: 7%;
	color:black;
}

button {
	width: 15%;
}
</style>
</head>
<body>
	<%@include file="SellerAdmin.jsp"%>
	<h2>Add Product Details</h2>
	<div id="body">
		<details:form action="/addP" method="Post"
			enctype="multipart/form-data">
				<label>compName </label>
			<input type="text" name="compName" class="form-control mb-4"
				placeholder="Product Id">

			<label>cateName Name</label>
			<input type="text" name="cateName" class="form-control mb-4"
				placeholder="Product Name">

			<label>Product Id</label>
			<input type="text" name="procId" class="form-control mb-4"
				placeholder="Product Id">

			<label>Product Name</label>
			<input type="text" name="procName" class="form-control mb-4"
				placeholder="Product Name">

			<label>RAM</label>
			<select name="ram" class="form-control mb-4">
				<option>4GB</option>
				<option>6GB</option>
				<option>8GB</option>
				<option>12GB</option>
			</select>

			<label>Storage</label>
			<select name="Storage" class="form-control mb-4">
				<option>64GB</option>
				<option>128GB</option>
				<option>256GB</option>
				<option>512GB</option>
			</select>

			<label>Offer</label>
			<input type="text" name="description" class="form-control mb-4"
				placeholder="Product Offers">

			   <label>Product Price</label>
			   <input type="text" name="price" class="form-control mb-4"
				placeholder="Product Price">

   				<label>Product Description</label>
			   <input type="text" name="description" class="form-control mb-4"
				placeholder="Product Price">
				
				
			  <label>Product Images</label>
			  <input type="file" name="file">


			<button class="btn btn-info btn-block" type="submit">Save</button>
		
		</details:form>
	</div>
</body>
</html>