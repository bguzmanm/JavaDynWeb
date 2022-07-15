<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cliente</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<header>
			<%@include file="header.jsp"%>
			<h3>Edición de Cliente</h3>
		</header>
		<main>

			<form action="${pageContext.request.contextPath}/customer?op=${op}"
				method="post" class="form">
				<div class="row pt-3">
					<div class="col">
						<label for="customer_id" class="form-label">Id</label> <input
							type="text" class="form-control" id="customer_id"
							name="customer_id" value="${customer.getCustomer_id()}" readonly>
					</div>
					<div class="col">
						<label for="first_name" class="form-label">Nombre</label> <input
							type="text" class="form-control" id="first_name"
							name="first_name" value="${customer.getFirst_name()}">
					</div>
				</div>
				<div class="row pt-3">
					<div class="col">
						<label for="last_name" class="form-label">Apellido</label> <input
							type="text" class="form-control" id="last_name" name="last_name"
							value="${customer.getLast_name()}">
					</div>
					<div class="col">
						<label for="email" class="form-label">Email</label> <input
							type="email" class="form-control" id="email" name="email"
							value="${customer.getEmail()}">
					</div>
				</div>
				<div class="row pt-3">
					<div class="col-2">
						<label for="active" class="form-label">Activo</label> <input
							type="text" class="form-control" id="active" name="active"
							value="${customer.getActive()}">
					</div>
				</div>
				<div class="row pt-3">
					<div class="col">
						<button type="submit" class="btn btn-primary">Guardar</button>
					</div>
					<div class="col">
						<button type="reset" class="btn btn-secondary">Limpiar</button>
					</div>
				</div>
			</form>
		</main>
	</div>

</body>
</html>