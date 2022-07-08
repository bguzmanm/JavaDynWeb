<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Gestión de Direcciones</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<div class="container">
<div>
	<%@include file="header.jsp" %>
	<h1>Plataforma de Gestión de Direcciones</h1>
	
	<h3>
	<%
	
		Cookie[] galletas = request.getCookies();
		Cookie chocolate = null;
		
		for (int i = 0; i <galletas.length; i++){
			if (galletas[i].getName().equalsIgnoreCase("nombre")){
				chocolate = galletas[i];
			}
		}
		
		if (chocolate != null){
			out.print(chocolate.getValue());
		}
	
	 %>
	 </h3>
	

</div>
</div>
	
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>