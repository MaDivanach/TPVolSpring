<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title></title>
</head>
<body>
	<div class="container">
		<table class="table">
			<tr>
				<th>id</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Rue</th>
				<th>Code postal</th>
				<th>Ville</th>
				<c:forEach items="${passagers}" var="passager">
					<tr>
						<td>${passager.idPassager}</td>
						<td>${passager.nom}</td>
						<td>${passager.prenom}</td>
						<td>${passager.adresse.numero}${passager.adresse.rue}</td>
						<td>${passager.adresse.codePostal}</td>
						<td>${passager.adresse.ville }</td>

						<td><a href="./reservations?id=${passager.idPassager}"
							class="btn btn-secondary">Liste reservations</a></td>
						<td><a href="./delete?id=${passager.idPassager}"
							class="btn btn-danger">supprimer</a></td>
						<td><a href="./edit?id=${passager.idPassager}"
							class="btn btn-primary">edition</a></td>
					</tr>
				</c:forEach>
		</table>
		<a href="./add" class="btn btn-primary">ajouter passager</a>

	</div>
</body>
</html>