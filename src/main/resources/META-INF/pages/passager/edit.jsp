<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<fieldset>
			<legend>edition d'adherent</legend>
			<form:form action="save" method="get" modelAttribute="passager">
				<form:hidden path="version" />
				<div class="form-group">
					<form:label path="idPassager">id:</form:label>
					<form:input path="idPassager" cssClass="form-control"
						readonly="true" />
				</div>
				<div class="form-group">
					<form:label path="nom">Nom:</form:label>
					<form:input path="nom" cssClass="form-control" />
					<form:errors path="nom"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="prenom">Prenom:</form:label>
					<form:input path="prenom" cssClass="form-control is-valid" />
					<form:errors path="prenom"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="adresse.numero">Numero:</form:label>
					<form:input path="adresse.numero" cssClass="form-control"
						type="number" />
				</div>
				<div class="form-group">
					<form:label path="adresse.rue">Rue:</form:label>
					<form:input path="adresse.rue" cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="adresse.codePostal">Code Postal:</form:label>
					<form:input path="adresse.codePostal" cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="adresse.ville">Ville:</form:label>
					<form:input path="adresse.ville" cssClass="form-control" />
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-success">Enregistrer</button>
				</div>
				<div class="form-group">
					<a href="./" class="btn btn-danger">Annuler </a>
				</div>
			</form:form>
		</fieldset>
	</div>
</body>
</html>