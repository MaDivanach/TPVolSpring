<%@page import="com.sopra.TPVolBoot.model.CompagnieAerienne"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<title>adherents</title>
</head>
<body>
	<div class="container">
		<table class="table">
			<tr>
				<th>identifiant</th>
				<th>nom de la compagnie</th>
			</tr>
			<c:forEach items="${CompagnieAeriennes}" var="compagnieAerienne">
				<tr>
					<td>${compagnieAerienne.id }</td>
					<td>${compagnieAerienne.nom }</td>
					<td><a href="./delete?id=${compagnieAerienne.id}" class="btn btn-danger">supprimer</a></td>
					<td><a href="./edit?id=${compagnieAerienne.id}" class="btn btn-secondary">éditer</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="./add" class="btn btn-primary">ajouter nouvelle compagnie</a>
	</div>
</body>
</html>