<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Detalle Artista</title>
	</head>
	<body>
		<h1>Detalle de Artista:</h1>
		<ul>
			<li><p>Nombre: ${artista.nombre}</p></li>
			<li><p>Apellido: ${artista.apellido}</p></li>
			<li><p>Biografia: ${artista.biografia}</p></li>
			<li><c:forEach var="cancion" items="${artista.canciones}">
				<p>Canciones: ${cancion.titulo}</p>
        	</c:forEach></li>
		</ul>
			<a href='<c:url value="/artistas"/>'>Volver a lista de artistas</a>
	</body>
</html>