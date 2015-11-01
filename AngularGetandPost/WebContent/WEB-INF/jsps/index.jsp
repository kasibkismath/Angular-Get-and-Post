<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html lang="en" ng-app="personApp">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Angluar JS</title>

<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"
	rel="stylesheet">

<!-- External Stylesheet -->
<link
	href="${pageContext.request.contextPath}/static/css/style.css"
	rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body ng-controller="mainController">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"> <span>Angluar</span>
				</a>
			</div>
		</div>
	</nav>
	<div class="container">
		<h3>Person</h3>
		<hr>
	</div>
	<div class="container">
		<table class="table table-bordered">
			<tr>
				<th>#</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Occupation</th>
			</tr>
			<tr ng-repeat="person in persons">
				<td>{{ person.id }}</td>
				<td>{{ person.firstname }}</td>
				<td>{{ person.lastname }}</td>
				<td>{{ person.occupation }}</td>
			</tr>
		</table>
	</div>
	<div class="container">
		<form class="personForm">
			<div class="form-group">
				<label for="firstname">First Name</label> <input type="text"
					class="form-control" id="firstname" placeholder="First Name" ng-model="firstname">
			</div>
			<div class="form-group">
				<label for="lastname">Last Name</label> <input type="text"
					class="form-control" id="lastname" placeholder="Last Name" ng-model="lastname">
			</div>
			<div class="form-group">
				<label for="occupation">Occupation</label> <input type="text"
					class="form-control" id="occupation" placeholder="Occupation" ng-model="occupation">
			</div>
			<button type="button" class="btn btn-success" ng-click="addPerson()">Add Person</button>
		</form>
	</div>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
	<!-- Loading Angluar JS using CDN -->
	<script src="//code.angularjs.org/1.4.7/angular.min.js"></script>
	<!-- Include External JS files -->
	<script src="${pageContext.request.contextPath}/static/js/app.js"></script>
</body>

</html>