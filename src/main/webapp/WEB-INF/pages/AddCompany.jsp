<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Company Details</title>
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
	padding-left: 520px;
	padding-top: 2%;
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
	<h2>Add Company Details</h2>
	<div id="body">
		<form:form action="result" method="post" modelAttribute="companydetails">
			<div class="form-outline mb-4">
				<label class="form-label" for="form4Example1">Company Id</label> <input
					type="text" name="compId" id="compId" class="form-control" />
			</div>
			<div class="form-outline mb-4">
				<label class="form-label" for="form4Example2">Company Name</label> <input
					type="text" name="compName" id="compName" class="form-control" />
			</div>
			<button type="submit" class="btn btn-primary btn-block mb-4">Save</button>
		</form:form>
	</div>
</body>
</html>