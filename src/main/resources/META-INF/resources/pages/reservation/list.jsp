<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.sopra.TPVolSpring.model.*"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>TP VOL MVC - Réservations</title>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
		integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
		crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
		integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
		crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<div access="hasRole('ROLE_ADMIN')">
			<c:if test="${pageContext.request.userPrincipal.name !=null }">
				logged as:${pageContext.request.userPrincipal.name}
				<a href="../logout">logout</a>
			</c:if>
		</div>
		<div class="row">
			<h1>Liste des Réservations</h1>
		</div>
		<div class="row">
			<table class="table table-striped">
				<tr>
					<th>Identifiant</th>
					<th>Numéro</th>
					<th>Date</th>
					<th>Type de client</th>
					<th>Identifiant client</th>
					<th>Nom du client</th>
					<th>Passager</th>
					<th>Vol</th>
					<th>Modifications</th>
				</tr>
				<c:forEach items="${reservations}" var="reservation">
					<tr>
						<td>${reservation.id}</td>
						<td>${reservation.numero}</td>
						<td>${reservation.date}</td>
						<td>${reservation.client.id}</td>
						<td>${reservation.client.getClass().simpleName}</td>
						<td>
							${reservation.client.nom}
							<c:if test="${reservation.client.getClass().simpleName == 'ClientPhysique' || reservation.client.getClass().simpleName == 'ClientPhysique'}">
								${reservation.client.prenom}
							</c:if>
							<c:if test="${reservation.client.getClass().simpleName == 'ClientMoral'}">
								${reservation.client.siret}
							</c:if>
						</td>
						<td>${reservation.passager.idPassager} ${reservation.passager.nom} ${reservation.passager.prenom}</td>
						<td>${reservation.vol.depart.nom} ${reservation.vol.arrivee.nom} ${reservation.vol.heureDepart} ${reservation.vol.heureArrivee} </td>
						<td>
							<a href="./edit?id=${reservation.id}" class="btn btn-warning">Modifier</a> 
							<a href="./delete?id=${reservation.id}" class="btn btn-danger">Supprimer</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div access="hasRole('ROLE_USER')">
				<c:if test="${client !=null }">
					<a href="./add?clientId=${client}" class="btn btn-success">Ajouter une réservation</a>
				</c:if>
			<div access="hasRole('ROLE_ADMIN')">
				<a href="./addAdmin" class="btn btn-success">Ajouter une réservation</a> 
			</div>
			</div>
		</div>
</body>
</html>