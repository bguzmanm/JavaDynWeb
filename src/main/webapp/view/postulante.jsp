<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro Postulante</title>
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
			<h3>Crea un nuevo Postulante</h3>
		</header>
		<main>
			<form action="${pageContext.request.contextPath}/postulantes/new"
				method="post" class="form">
				<div class="row pt-3">
					<div class="col">
						<input type="text" class="form-control" id="nombre" name="nombre"
							placeholder="Nombre" aria-label="Nombre">
					</div>
					<div class="col">
						<input type="text" class="form-control" placeholder="Apellido"
							id="apellido" name="apellido" aria-label="Apellido">
					</div>
				</div>
				<div class="row pt-3">
					<div class="col">
						<input type="number" class="form-control" placeholder="46"
							id="edad" name="edad" aria-label="46">
					</div>
					<div class="col">
						<input type="number" step="any" class="form-control" placeholder="6.5"
							id="nota" name="nota" aria-label="6.5">
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