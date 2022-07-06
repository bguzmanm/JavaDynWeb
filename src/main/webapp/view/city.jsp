<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ciudad</title>
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
			<h3>
				<c:out value="${titulo}"></c:out>
			</h3>
		</header>
		<main>

			<c:if test="${city.getCity_id() != null}">
			<c:url var="action" value="/city">
				<c:param name="op" value="edit"></c:param>
			</c:url>
			</c:if>
			<c:if test="${city.getCity_id() == null}">
			<c:url var="action" value="/city">
				<c:param name="op" value="new"></c:param>
			</c:url>
			</c:if>
			
			<form action="${action}" method="post" class="form">
				<div class="row pt-3">
					<div class="col">
						<label for="city_id" class="form-label">Id:</label> <input
							type="text" class="form-control" id="city_id" name="city_id"
							value="${city.getCity_id()}" readonly>
					</div>
				</div>
				<div class="row pt-3">
					<div class="col">
						<label for="city" class="form-label">Nombre:</label> <input
							type="text" class="form-control" id="city" name="city"
							value="${city.getCity()}">
					</div>
				</div>
				<div class="row pt-3">
					<div class="col">
						<label for="country" class="form-label">País:</label> 
						
						<select name="country" id="country" class="form-select">
						<c:forEach var="country" items="${countrys}">
							<c:if test="${country.getCountry_id() == city.getCountry_id()}">
							<option value="${country.getCountry_id()}" selected><c:out value="${country.getCountry()}"></c:out></option>
							</c:if>
							<c:if test="${country.getCountry_id() != city.getCountry_id()}">
							<option value="${country.getCountry_id()}"><c:out value="${country.getCountry()}"></c:out></option>
							</c:if>
						</c:forEach>
						</select>
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