<%@page import="java.util.List"%>
<%@page import="cl.sustantiva.model.entity.City"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Dirección</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
			<form action="${pageContext.request.contextPath}/address?op=edit" method="post" class="form">
				<div class="row pt-3">
					<div class="col">
						<label for="address_id" class="form-label">Id:</label> <input type="text" class="form-control"
							id="address_id" name="address_id" value="${address.getAddress_id()}" readonly>
					</div>
				</div>
				<div class="row pt-3">
					<div class="col">
						<label for="address" class="form-label">Dirección:</label> <input type="text"
							class="form-control" id="address" name="address" value="${address.getAddress()}">
					</div>
				</div>
				<div class="row pt-3">
					<div class="col">
						<label for="address2" class="form-label">Dirección 2:</label> <input type="text"
							class="form-control" id="address2" name="address2" value="${address.getAddress2()}">
					</div>
				</div>
				<div class="row pt-3">
					<div class="col">
						<label for="country" class="form-label">País:</label>

						<select name="country" id="country" class="form-select">
							<c:forEach var="country" items="${countrys}">
								<c:if test="${country.getCountry_id() == address.getCity().getCountry_id()}">
									<option value="${country.getCountry_id()}" selected>
										<c:out value="${country.getCountry()}"></c:out>
									</option>
								</c:if>
								<c:if test="${country.getCountry_id() !=  address.getCity().getCountry_id()}">
									<option value="${country.getCountry_id()}">
										<c:out value="${country.getCountry()}"></c:out>
									</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row pt-3">
					<div class="col">
						<label for="city" class="form-label">Ciudad:</label>

						<select name="city" id="city" class="form-select">
							<c:forEach var="city" items="${citys}">
								<c:if test="${city.getCity_id() == address.getCity_id()}">
									<option value="${city.getCity_id()}" selected>
										<c:out value="${city.getCity()}"></c:out>
									</option>
								</c:if>
								<c:if test="${city.getCity_id() != address.getCity_id()}">
									<option value="${city.getCity_id()}">
										<c:out value="${city.getCity()}"></c:out>
									</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row pt-3">
					<div class="col">
						<label for="district" class="form-label">Distrito:</label> <input type="text"
							class="form-control" id="district" name="district" value="${address.getDistrict()}">
					</div>
				</div>
				<div class="row pt-3">
					<div class="col">
						<label for="phone" class="form-label">Teléfono:</label> <input type="tel"
							class="form-control" id="phone" name="phone" value="${address.getPhone()}">
					</div>
				</div>
				<div class="row pt-3">
					<div class="col">
						<label for="postalcode" class="form-label">Código Postal:</label> <input type="text"
							class="form-control" id="postalcode" name="postalcode" value="${address.getPostal_code()}">
					</div>
				</div>
				<div class="row pt-3">
					<div class="col">
						<label for="location" class="form-label">Coordenadas Decimales:</label> <input type="text"
							class="form-control" id="location" name="location" value="${address.getLocation()}">
					</div>
				</div>
				<div class="row pt-3 pb-3">
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

<script>

<% 
	List<City> citys = (List<City>)request.getAttribute("citys");

	int pais_old = 0;
	boolean inicio = false;
	out.println("$.paises = [");
	
	for(City city: citys){
		if (city.getCountry_id() != pais_old){
			if (inicio){
				out.print("]}, {");
				inicio = false;
			} else {
				out.print("{ ");
			}
			out.println(" \"id\": " + city.getCountry_id() + ", ");
			out.print(" \"ciudades\": [");
			inicio = true;
		} else {
			out.println(", ");
		}
		out.print("{\"id\": \"" + city.getCity_id() + "\", \"nombre\": \"" + city.getCity() + "\"}");
		
		pais_old = city.getCountry_id();
	}
	out.println("] } ]");
%>

	$("#country").change(function (e) {

		let id_pais = $("#country").val();
		$.each($.paises, function (id, pais){
			if (pais.id == id_pais){				
				$("#city").empty();				
				$.each(pais.ciudades, function (id, ciudad) {
					$("#city").append("<option value=" + ciudad.id + ">" + ciudad.nombre + "</option>");
					
				});
			}
		});
	});
</script>

</html>