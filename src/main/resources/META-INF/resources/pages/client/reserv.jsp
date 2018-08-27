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

		<table class="table">
			<tr>
				<th>Id reservation</th>

			</tr>


			<c:forEach items="${reservations}" var="reservation">
			coucou
<!-- 				<tr> -->
<%-- 					<td>${reservation.numero}</td> --%>
<!-- 				</tr> -->
			</c:forEach>

		</table>

	</div>

</body>
</html>