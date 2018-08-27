<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.sopra.TPVolBoot.model.*"%>
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
		<fieldset>
			<legend>Formulaire Reservations</legend>
			<form:form action="save" method="get" modelAttribute="reservation">
				<form:input hidden="hidden" path="version"/>
				<div class="form-group">
					<form:label path="id">ID : </form:label>
					<form:input path="id" cssClass="form-control" readonly="true"/>
					<form:label path="date">Date de réservation </form:label>
<%-- 					<form:input type="date" path="date" cssClass="form-control"/> --%>
<%-- 					<form:errors path="date"></form:errors> --%>
				</div>
				<div class="form-group">
					<form:label path="numero">Numéro de réservation </form:label>
					<form:input type="number" path="numero" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<label for="clientId">Client </label>
					<select name="clientId"  class="form-control">
						<option value="">(aucun)</option>
						<c:forEach items="${clients}" var="client">
							<option value="${client.id_client}">${client.nom}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<form:label path="vol.id">Vol </form:label>
					<form:select path="vol.id" cssClass="form-control">
						<form:option value="">(aucun)</form:option>
						<form:options items="${vols}" itemLabel="numero" itemValue="id"/>
					</form:select>
				</div>
				<div class="form-group">
					<form:label path="passager.idPassager">Passager </form:label>
					<form:select path="passager.idPassager" cssClass="form-control">
						<form:option value="">(aucun)</form:option>
						<form:options items="${passagers}" itemLabel="nom" itemValue="idPassager"/>
					</form:select>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-success">Enregistrer</button>
					<button type="reset" class="btn btn-warning">Réinitialiser</button> 
					<a href="./" class="btn btn-danger">Quitter</a>
				</div>
			</form:form>
		</fieldset>
	</div>
</body>
</html>