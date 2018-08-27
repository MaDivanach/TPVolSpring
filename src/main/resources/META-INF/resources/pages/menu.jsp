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

<title>Menu</title>
</head>
<body class="container">
	<header>
		<div class="jumbotron jumbotron-fluid">
			<div class="row">
				<div class="col-sm-5"></div>
				<h1 class="display-10 col-sm-4">MENU</h1>
				<div class="col-sm-3"></div>
			</div>
		</div>
	</header>
	<div>
		${pageContext.request.userPrincipal.name}
		<div access="hasRole('ROLE_ADMIN')">
			<c:if test="${pageContext.request.userPrincipal.name !=null }">
                    logged as:${pageContext.request.userPrincipal.name}
                        <a href="../logout">logout</a>
			</c:if>
		</div>
	</div>
	<div class="row">
		<div class="card col-sm-6" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title">Clients</h5>
				<p class="card-text">Consultez la liste des clients enregistrés
					dans notre base de données</p>
				<a href="./client" class="btn btn-primary">Ici</a>

			</div>
		</div>
		<div class="card col-sm-6" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title">Passagers</h5>
				<p class="card-text">Consultez la liste des passagers
					enregistrés dans notre base de données</p>
				<a href="./passager" class="btn btn-primary">Ici</a>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="card col-sm-6" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title">Vols</h5>
				<p class="card-text">Consultez la liste des vols enregistrés
					dans notre base de données</p>
				<a href="./vol" class="btn btn-primary">Ici</a>
			</div>
		</div>
		<div class="card col-sm-6" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title">Reservations</h5>
				<p class="card-text">Consultez la liste des réservations
					enregistrées dans notre base de données</p>
				<a href="./reservation" class="btn btn-primary">Ici</a>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="card col-sm-6" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title">Compagnies Aériennes</h5>
				<p class="card-text">Consultez la liste des compagnies aériennes
					enregistrées dans nos base de données</p>
				<a href="./compagnieAerienne"
					class="btn btn-primary">Ici</a>
			</div>
		</div>
		<div class="card col-sm-6" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title">Hébergez vos données chez nous !</h5>
				<p class="card-text">Hébergez vos données personnelles sur nos
					serveurs pour seulement 99.99€/mois !</p>
				<a href="#" class="btn btn-danger">Saisissez votre chance !</a>
			</div>
		</div>
	</div>


</body>
<footer>
	<div class=row>
		<div class=col-sm-4>© Copyright BestAjcGroupEver</div>
		<div class=col-sm-6></div>
		<div class=col-sm-2>2018</div>
	</div>
</footer>
</html>