<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Editar Cancion</title>
	</head>
	<body>
		<h1>Editar Cancion:</h1>
		<form:form modelAttribute="cancion" action="/canciones/procesa/editar/${cancion.id}" method="POST">
		    <div>
		    	<input type="hidden" name="_method" value="PUT"/>
		     	<form:label path="titulo">Titulo</form:label>
		     	<form:input path="titulo" value="${cancion.titulo}"/>
		     	<form:errors path="titulo" cssClass="error"/>
		    </div>
		     <div>
		     	<form:label path="artista">Artista</form:label>
		     	<form:input path="artista" value="${cancion.artista}"/>
		     	<form:errors path="artista" cssClass="error"/>
		    </div>
		     <div>
		     	<form:label path="album">Album</form:label>
		     	<form:input path="album" value="${cancion.album}"/>
		     	<form:errors path="album" cssClass="error"/>
		    </div>
		     <div>
		     	<form:label path="genero">Genero</form:label>
		     	<form:input path="genero" value="${cancion.genero}"/>
		     	<form:errors path="genero" cssClass="error"/>
		    </div>
		     <div>
		     	<form:label path="idioma">Idioma</form:label>
		     	<form:input path="idioma" value="${cancion.idioma}"/>
		     	<form:errors path="idioma" cssClass="error"/>
		    </div>
	       	<button type="submit">Editar Cancion</button>
	    </form:form>
	    <a href='<c:url value="/canciones"/>'>Volver a Lista de Canciones</a>
	</body>
</html>