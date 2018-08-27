<%@page import="com.sopra.TPVolBoot.model.Vol"%>
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
<title>Vols</title>
</head>
<body>
	<div class="container">
		<header>
			<div class="jumbotron jumbotron-fluid">
				<div class="row">
					<div class="col-sm-3">
						<img src="../images/book.png" alt=":(">
					</div>
					<div class="col-sm-9">
						<h1 class="display-4">La Page Des Vols</h1>
						<p class="lead">Il n'a jamais été aussi simple de créer un vol</p>
					</div>
				</div>


			</div>

		</header>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Identifiant</th>
					<th scope="col">Date de départ</th>
					<th scope="col">Date d'arrivée</th>
					<th scope="col">Heure de départ</th>
					<th scope="col">Heure d'arrivée</th>
					<th scope="col">Départ</th>
					<th scope="col">Arrivée</th>
					<th scope="col">Réservations</th>
					<th scope="col"></th>
					<th scope="col"></th>
				</tr>
			</thead>
			<c:forEach items="${vols}" var="vol">
				<tr>
					<td>${vol.id}</td>
					<td>${vol.dateDepart}</td>
					<td>${vol.dateArrivee}</td>
					<td>${vol.heureDepart}</td>
					<td>${vol.heureArrivee}</td>
					<td>${vol.depart.nom}</td>
					<td>${vol.arrivee.nom}</td>
					<td><a href="./detail?id=${vol.id}" class="btn btn-info">Detail</a> </td>
					<td><a href="./delete?id=${vol.id}"
						class="btn btn-danger">Supprimer</a></td>
					<td><a href="./edit?id=${vol.id}" class="btn btn-primary">Editer</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="row">
			<div class=col-sm-2>
				<a href="./add" class="btn btn-success btn-lg b1">Ajouter un vol</a>
			</div>
			<div class=col-sm-2>
				<button class="btn btn-primary btn-lg b1" type="button"
					data-toggle="collapse" data-target="#collapseExample"
					aria-expanded="false" aria-controls="collapseExample">A
					propos</button>

			</div>
			<div class="collapse" id="collapseExample">
				<div class="card card-body">Developpé par Jimmy</div>
			</div>
		</div>

	</div>
</body>
</html>