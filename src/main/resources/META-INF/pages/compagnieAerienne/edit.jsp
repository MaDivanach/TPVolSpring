<%@page import="com.sopra.TPVolSpring.model.CompagnieAerienne"%>
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

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<title>adherents</title>
</head>
<body>
	<div class="container">
		<fieldset>
			<legend>edition de compagnie</legend>
				<form:form action="save" method="get" modelAttribute="compagnieAerienne">
					<form:hidden path="version"/>
						<div class="form-group">
							<form:label path="id">id:</form:label>
							<form:input path="id" cssClass="form-control" readonly="true"></form:input>
						</div>
						<div class="form-group">
							<form:label path="nom">nom de la compagnie:</form:label>
							<form:input path="nom" cssClass="form-control"></form:input>
							<form:errors path="nom"></form:errors>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-success" >enregistrer</button>
							<a href="" class="btn btn-warning" >annuler</a>
						</div>
				</form:form>
		</fieldset>
	</div>
</body>
</html>