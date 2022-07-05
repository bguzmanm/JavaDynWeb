<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de Paises</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="http://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css" rel="stylesheet">
<script src="http://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script src="https://kit.fontawesome.com/81a2ed02b0.js" crossorigin="anonymous"></script>

</head>
<body>

	<div class="container">
		<header>
			<%@include file="header.jsp"%>
			<h1>Listado de Paises</h1>
		</header>
		<main>
			<a class="btn btn-primary" href="${pageContext.request.contextPath}/country?op=new">Crear nuevo País</a>
			<table class="table" id="paises">
				<thead class="table-dark">
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${countrys}">
						<tr>
							<th><c:out value="${c.getCountry_id()}"></c:out></th>
							<td><c:out value="${c.getCountry()}"></c:out></td>
							<td>
								<a href="${pageContext.request.contextPath}/country?id=${c.getCountry_id()}">
									<i class="fa-solid fa-pen-to-square"></i></a>
								 
								<a href="${pageContext.request.contextPath}/country?id=${c.getCountry_id()}&op=del">
									<i class="fa-solid fa-trash"></i></a>
							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</main>
	</div>
<script>
$(document).ready( function () {
    $('#paises').DataTable();
} );
</script>

</body>
</html>