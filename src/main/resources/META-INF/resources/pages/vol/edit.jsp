<%@page import="javax.servlet.jsp.tagext.TagSupport"%>
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
<title>Edition de vol</title>
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

		<fieldset>
			<legend>Edition de vol</legend>
			<form:form action="./save" method="get" modelAttribute="vol">
				<form:hidden path="version" />
				<div class="form-group">
					<div>
						<form:label path="id">Id</form:label>
						<form:input path="id" cssClass="form-control" readonly="true" />
					</div>
					<div class="form-group">
						<form:label path="dateDepart">Date de départ</form:label>
						<form:input path="dateDepart" cssClass="form-control" type="date" />
						<form:errors path="dateDepart"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="dateArrivee">Date d'arrivée</form:label>
						<form:input path="dateArrivee" cssClass="form-control" type="date" />
						<form:errors path="dateArrivee"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="heureDepart">Heure de départ</form:label>
						<form:input path="heureDepart" cssClass="form-control" type="time" />
						<form:errors path="heureDepart"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="heureArrivee">Heure d'arrivée</form:label>
						<form:input path="heureArrivee" cssClass="form-control"
							type="time" />
						<form:errors path="heureArrivee"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="depart.id">Aeroport de départ</form:label>
						<form:select path="depart.id" cssClass="form-control">
							<form:option value="" disabled="disabled">Choisissez l'aeroport de départ</form:option>
							<form:options items="${aeroports}" itemLabel="description" itemValue="id" />
						</form:select>
					</div>
					<div class="form-group">
						<form:label path="arrivee.id">Aeroport de d'arrivée</form:label>
						<form:select path="arrivee.id" cssClass="form-control">
							<form:option value="" disabled="disabled">Choisissez l'aeroport d'arrivée</form:option>
							<form:options items="${aeroports}" itemLabel="description" itemValue="id" />
						</form:select>
					</div>

				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-success">Sauvegarder</button>
					<button type="reset" class="btn btn-primary">Reset</button>
					<a href="./" class="btn btn-danger">Cancel</a>
				</div>
			</form:form>
		</fieldset>

	</div>


</body>
</html>