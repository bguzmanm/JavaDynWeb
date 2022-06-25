<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Postulaciones a Becas</title>
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
			<%@include file="header.jsp" %>
			<h1>Plataforma de postulación a Becas Sustantiva</h1>
			<h2>${nombre}</h2>
		</header>
		<main>
			<table class="table">
				<thead class="table-dark">
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Edad</th>
						<th>Nota</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="p" items="${postulantes}">
						<tr>
							<th><c:out value="${p.getId()}"></c:out></th>
							<td><c:out value="${p.getNombre()}"></c:out></td>
							<td><c:out value="${p.getApellido()}"></c:out></td>
							<td><c:out value="${p.getEdad()}"></c:out></td>
							<td><c:out value="${p.getNota()}"></c:out></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</main>

	</div>

	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>