<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>País</title>
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
			<h3><c:out value="${titulo}"></c:out></h3>
		</header>
		<main>
			
			<form action="${pageContext.request.contextPath}/country"
				method="post" class="form">
				<div class="row pt-3">
					<div class="col">
						<label for="country_id" class="form-label">Id:</label>
						<input type="text" class="form-control" id="country_id" name="country_id" value="${country.getCountry_id()}" readonly>
					</div>
					<div class="col">
						<label for="country" class="form-label">Nombre:</label>
						<input type="text" class="form-control" id="country" name="country" value="${country.getCountry()}" >
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