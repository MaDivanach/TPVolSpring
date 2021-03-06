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
<title>Client</title>
</head>
<body>
	<div class="container">
	<div>

		<div access="hasRole('ROLE_ADMIN')">
			<c:if test="${pageContext.request.userPrincipal.name !=null }">
                    logged as:${pageContext.request.userPrincipal.name}
                        <a href="../logout">logout</a>
			</c:if>
		</div>
		
	</div>

		<table class="table">
		<tr>
		<th>
			<a href="./menu"
                        class="btn btn-primary">Menu</a>
                        </th>
                        </tr>
			<tr>
				<th>type</th>
				<th>id</th>
				<th>nom</th>
				<th>prenom</th>
				<th>siret</th>
				<th>telephone</th>
				<th>Reservation</th>
				<th></th>
				<th></th>
			</tr>


			<c:forEach items="${clients}" var="client">
				<tr>
					<td>${client.getClass().simpleName }</td>
					<td>${client.id_client }</td>
					<td>${client.nom }</td>

					<td><c:if
							test="${client.getClass().simpleName!='ClientMoral' }">		
						${client.prenom }
					</c:if></td>
					<td><c:if
							test="${client.getClass().simpleName=='ClientMoral' }">		
						${client.siret }
					</c:if></td>
					<td>${client.numeroTel }</td>
					
					<td><a href="./reservations?id=${client.id_client}"
						class="btn btn-success">Voir liste</a></td>
					<td><a href="./delete?id=${client.id_client}"
						class="btn btn-danger">supprimer</a></td>
					<td><a href="./edit?id=${client.id_client}"
						class="btn btn-primary">edition</a></td>
				</tr>
			</c:forEach>

		</table>
		<a href="./addphysique" class="btn btn-primary">ajout Client
			Physique</a> <a href="./addmoral" class="btn btn-primary">ajout
			Client Moral</a> <a href="./addel" class="btn btn-primary">ajout
			Client El</a>

</div>


</body>
</html>