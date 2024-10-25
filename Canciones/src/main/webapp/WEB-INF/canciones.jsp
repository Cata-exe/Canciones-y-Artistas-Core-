<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lista de Canciones</title>
	</head>
	<body>
	<h1>Lista de canciones:</h1>
		<table border="1">
			<thead>
				<tr>
					<th>Titulo</th>
					<th>Autor</th>
					<th>Detalle</th>
					<th>Editar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cancion" items="${canciones}">
					<tr>
						<td>${cancion.titulo}</td>
						<td>${cancion.artista.nombre} ${cancion.artista.apellido}</td>
						<td><a href='<c:url value="/canciones/detalle/${cancion.id}"/>'>Ver Detalles</a></td>
						<td><a href='<c:url value="canciones/formulario/editar/${cancion.id}"/>'>Editar Informacion</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a href='<c:url value="canciones/formulario/agregar"/>'>Agregar Cancion</a>
		</div>
			<a href="/artistas">Ir a Artistas</a>
	</body>
</html>