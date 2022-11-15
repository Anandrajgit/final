<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head lang="en">
<meta charset="UTF-8" />
<title>HELLO</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</head>

<body>

		<div class="col-12">
			
			
            <h3 class="text-center">list of products</h3>
			<hr>
			<table class="table">
				<thead class="thead-dark">
					<tr>
			    <th>SI.NO</th>
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
		<tbody>
		<tr th:each="product : ${products}">
						<th scope="row"><img alt="" th:src="*{'data:image/jpeg;base64,'+{product.image}}" style="width: 600px;height: 600px;"></th>
						<td>[[*{product.procName}]] 
						<!-- Button trigger modal --> <br>
							<button type="button" class="btn btn-success btn-sm mt-2"
								data-toggle="modal"
								th:attr="data-target='#exampleModalCenter'+*{product.id}">change
								name</button> <!-- Modal -->

							<div class="modal fade"
								th:id="*{'exampleModalCenter'+{product.id}}" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalCenterTitle"
								aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalCenterTitle">change
												product name</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">
											<form action="/changeName" method="post">
												<div class="form-group">
													<label>product id</label> <input type="hidden"
														th:value="*{product.id}" class="form-control" name="id">
													<label>new Product name</label> <input type="text"
														name="procName" class="form-control"> <br>
													<button type="submit" class="btn btn-primary">submit</button>
												</div>
											</form>

										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>

										</div>
									</div>
								</div>
							</div>

						</td>
						<td>[[*{product.description}]] <!-- Button trigger modal -->
							<br>
							<button type="button" class="btn btn-success btn-sm mt-2"
								data-toggle="modal"
								th:attr="data-target='#exampleModalCenterDesc'+${product.id}">change
								description</button> <!-- Modal -->
							<div class="modal fade"
								th:id="*{'exampleModalCenterDesc'+{product.id}}" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalCenterTitle"
								aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalCenterTitle">change
												product description</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">

											<form action="/changeDescription" method="post">
												<div class="form-group">
													<label>product id</label> <input type="text"
														th:value="*{product.id}" class="form-control" name="id">
													<label>new Product description</label> <input type="text"
														name="newDescription" class="form-control"> <br>
													<button type="submit" class="btn btn-primary">submit</button>
												</div>
											</form>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>

										</div>
									</div>
								</div>
							</div>
						</td>
						<td>[[*{product.price}]] <!-- Button trigger modal --> <br>
							<button type="button" class="btn btn-success btn-sm mt-2"
								data-toggle="modal"
								th:attr="data-target='#exampleModalCenterPrice'+${product.id}">change
								price</button> <!-- Modal -->
							<div class="modal fade"
								th:id="*{'exampleModalCenterPrice'+{product.id}}" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalCenterTitle"
								aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalCenterTitle">change
												product price</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">

											<form action="/changePrice" method="post">
												<div class="form-group">
													<label>product id</label> <input type="text"
														th:value="*{product.id}" class="form-control" name="id">
													<label>new Product price</label> <input type="text"
														name="newPrice" class="form-control"> <br>
													<button type="submit" class="btn btn-primary">submit</button>
												</div>
											</form>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
											<button type="button" class="btn btn-primary">Save
												changes</button>
										</div>
									</div>
								</div>
							</div>
						</td>
						<td><a th:href="@{/deleteProd/{id}(id=${product.id})}"
							class="btn btn-danger mt-4">delete</a></td>
					</tr>
				</tbody>
			</table>
			<hr>
		</div>
		</body>
		</html>