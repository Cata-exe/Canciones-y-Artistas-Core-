<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Agregar Cancion</title>
	</head>
	<body>
		<h1>Agregar Cancion:</h1>
		<form:form modelAttribute="cancion" action="/canciones/procesa/agregar" method="POST">
		    <div>
		     	<form:label path="titulo">Titulo</form:label>
		     	<form:input path="titulo"/>
		     	<form:errors path="titulo" cssClass="error"/>
		    </div>
		     <div>
		     	<form:label path="artista">Artista</form:label>
		     	<form:select path="artista.id">
		     		<form:options items="${artistas}" itemValue="id" itemLabel="Nombre"></form:options>
		     	</form:select>
		     	<form:errors path="artista" cssClass="error"/>
		    </div>
		     <div>
		     	<form:label path="album">Album</form:label>
		     	<form:input path="album"/>
		     	<form:errors path="album" cssClass="error"/>
		    </div>
		     <div>
		     	<form:label path="genero">Genero</form:label>
		     	<form:input path="genero"/>
		     	<form:errors path="genero" cssClass="error"/>
		    </div>
		     <div>
		     	<form:label path="idioma">Idioma</form:label>
		     	<form:input path="idioma"/>
		     	<form:errors path="idioma" cssClass="error"/>
		    </div>
	       	<button type="submit">Agregar Cancion</button>
	    </form:form>
	    <a href='<c:url value="/canciones"/>'>Volver a Lista de Canciones</a>
	</body>
</html>