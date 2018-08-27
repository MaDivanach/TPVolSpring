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
			<legend>edition de client</legend>
			<c:choose>
				<c:when test="${client.getClass().simpleName=='ClientMoral'}">
					<c:url value="savemoral" var="action"></c:url>
				</c:when>
				<c:when test="${client.getClass().simpleName=='ClientEl'}">
					<c:url value="saveel" var="action"></c:url>
				</c:when>
				<c:otherwise>
					<c:url value="savephysique" var="action"></c:url>
				</c:otherwise>


			</c:choose>
			<form:form action="${action}" method="get" modelAttribute="client">
				<%-- 				<form:hidden path="version" /> --%>
				<div class="form-group">
					<form:label path="id_client"> id:</form:label>
					<form:input path="id_client" cssClass="form-control"
						readonly="true" />
				</div>
				<div class="form-group">
					<form:label path="nom"> Nom:</form:label>
					<form:input path="nom" cssClass="form-control" />
<%-- 					<form:errors path="nom">Ajouter un nom svp</form:errors> --%>
				</div>
				<c:choose>
					<c:when test="${client.getClass().simpleName=='ClientMoral'}">
						<div class="form-group">
							<form:label path="siret"> Siret</form:label>
							<form:input path="siret" cssClass="form-control" />
						</div>
					</c:when>
					<c:otherwise>
						<div class="form-group">
							<form:label path="prenom"> Prénom</form:label>
							<form:input path="prenom" cssClass="form-control" />
						</div>
					</c:otherwise>
				</c:choose>
				<div class="form-group">
					<form:label path="numeroTel"> Numero de telephone:</form:label>
					<form:input path="numeroTel" cssClass="form-control" type="number" />
				</div>
				<div class="form-group">
					<form:label path="numeroFax"> Numero de fax:</form:label>
					<form:input path="numeroFax" cssClass="form-control" type="number" />
				</div>
				<div class="form-group">
					<form:label path="email"> Email:</form:label>
					<form:input path="email" cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="adresse.numero"> Numéro de rue:</form:label>
					<form:input path="adresse.numero" cssClass="form-control"
						type="number" />
				</div>
				<div class="form-group">
					<form:label path="adresse.rue"> Nom de la rue:</form:label>
					<form:input path="adresse.rue" cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="adresse.codePostal"> Code postale:</form:label>
					<form:input path="adresse.codePostal" cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:label path="adresse.ville"> Ville:</form:label>
					<form:input path="adresse.ville" cssClass="form-control" />
				</div>
				<!-- 				<div class="form-group"> -->
				<%-- 					<form:label path="login">Login:</form:label> --%>
				<%-- 					<form:select path="login.id" cssClass="form-control"> --%>
				<%-- 						<form:option value="">choisir</form:option> --%>
				<%-- 						<form:options items="${logins}" itemLabel="nom" --%>
				<%-- 							itemValue="id_login"></form:options> --%>
				<%-- 					</form:select> --%>
				<%-- 					<form:errors path="login"></form:errors> --%>
				<!-- 				</div> -->
				<div class="form-group">
					<button type="submit" class="btn btn-success">enregistrer</button>
				</div>
			</form:form>

		</fieldset>
	</div>

</body>
</html>