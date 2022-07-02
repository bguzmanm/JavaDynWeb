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
</head>
<body>

	<div class="container">
		<header>
			<%@include file="header.jsp"%>
			<h1>Listado de Paises</h1>
		</header>
		<main>
		<table class="table">
				<thead class="table-dark">
					<tr>
						<th>Id</th>
						<th>Nombre</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${countrys}">
						<tr>
							<th><c:out value="${c.getCountry_id()}"></c:out></th>
							<td><c:out value="${c.getCountry()}"></c:out></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</main>
	</div>


</body>
</html>