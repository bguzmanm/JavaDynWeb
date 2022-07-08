<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de Direcciones</title>
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
			<h1>Listado de Direcciones</h1>
		</header>
		<main>
			<a href="${pageContext.request.contextPath}/address?op=new"
				class="btn btn-primary">Crear Nueva Dirección</a>
			<table class="table" id="direcciones">
				<thead class="table-dark">
					<tr>
						<th>Id</th>
						<th>Dirección</th>
						<th>Dirección 2</th>
						<th>Distrito</th>
						<th>Ciudad</th>
						<th>País</th>
						<th>Código Postal</th>
						<th>Teléfono</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="a" items="${address}">
						<tr>
							<th><c:out value="${a.getAddress_id()}"></c:out></th>
							<td><c:out value="${a.getAddress()}"></c:out></td>
							<td><c:out value="${a.getAddress2()}"></c:out></td>
							<td><c:out value="${a.getDistrict()}"></c:out></td>
							<td><c:out value="${a.getCity().getCity()}"></c:out></td>
							<td><c:out value="${a.getCity().getCountry().getCountry()}"></c:out></td>
							<td><c:out value="${a.getPostal_code()}"></c:out></td>
							<td><c:out value="${a.getPhone()}"></c:out></td>							
							<td><a href="${pageContext.request.contextPath}/address?id=${a.getAddress_id()}&op=edit">
									<i class="fa-solid fa-pen-to-square"></i></a> 
								<a href="${pageContext.request.contextPath}/address?id=${a.getAddress_id()}&op=del">
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
			$('#direcciones').DataTable();
		});
	</script>

</body>
</html>