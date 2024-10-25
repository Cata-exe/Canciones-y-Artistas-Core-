<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Detalle de Canción</title>
	</head>
	<body>
		<h1>Detalle de Canción:</h1>
		<ul>
			<li><p>Titulo: ${cancion.titulo}</p></li>
			<li><p>Artista: ${cancion.artista.nombre} ${cancion.artista.apellido}</p></li>
			<li><p>Album: ${cancion.album}</p></li>
			<li><p>Genero: ${cancion.genero}</p></li>
			<li><p>Idioma: ${cancion.idioma}</p></li>
		</ul>
			<form action="/canciones/eliminar/${cancion.id}" method="POST">
				<input type="hidden" name="_method" value="DELETE"/>
				<button>Eliminar</button>
			</form>
			<a href='<c:url value="/canciones"/>'>Volver a Lista de Canciones</a>
	</body>
</html>