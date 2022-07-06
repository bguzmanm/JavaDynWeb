<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de Ciudades</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link
	href="http://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css"
	rel="stylesheet">
<script
	src="http://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script src="https://kit.fontawesome.com/81a2ed02b0.js"
	crossorigin="anonymous"></script>

</head>
<body>

	<div class="container">
		<header>
			<%@include file="header.jsp"%>
			<h1>Listado de Ciudades</h1>
		</header>
		<main>
			<a href="${pageContext.request.contextPath}/city?op=new"
				class="btn btn-primary">Crear Nueva Ciudad</a>
			<table class="table" id="ciudades">
				<thead class="table-dark">
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Pais</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${citys}">
						<tr>
							<th><c:out value="${c.getCity_id()}"></c:out></th>
							<td><c:out value="${c.getCity()}"></c:out></td>
							<td><c:out value="${c.getCountry().getCountry()}"></c:out></td>
							<td><a href="${pageContext.request.contextPath}/city?id=${c.getCity_id()}&op=edit">
									<i class="fa-solid fa-pen-to-square"></i></a> 
								<a href="${pageContext.request.contextPath}/city?id=${c.getCity_id()}&op=del">
									<i class="fa-solid fa-trash"></i>
							</a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</main>
	</div>
	<script>
		$(document).ready(function() {
			$('#ciudades').DataTable();
		});
	</script>

</body>
</html>