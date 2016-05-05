<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
 	
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

	<script src = "https://maps.googleapis.com/maps/api/js?key=AIzaSyDuiDw7TZPGDoAhZO_ghj1ygRzp52V-mcw&v=3.exp&signed_in=true&libraries=places"></script>
	<link rel="icon" type="image/jpg" href="images/weatherimage.png"/>

	<!-- Script for Angular JS -->
	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0rc1/angular-route.min.js"></script>
	
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>


	<!-- <script type="text/javascript">
		window.dataForWeather = ${data};
		window.placeForWeather = ${place};
	</script> -->



	<script type="text/javascript">
		var showWeather = angular.module('showWeather',['ngRoute']);

		showWeather.controller('showWeather', function($scope, $http, $route) {
			console.log(window.dataForWeather);
			console.log(window.placeForWeather);
		});

	</script>

	<!-- End Angular js -->
	<title>Trip Weather</title>
</head>
<body style="background-image:url('images/blackmamba.png');" ng-app="showWeather" ng-controller="showWeather">
<div class="container-fluid">
	<div class="row" style="background-image:url('images/homeimage.JPG');">
		<div class="col-md-4">
				
			<img src="images/weatherimage.png" height="40" width="40" style="margin-top: 15px; margin-left: 20px;" />
				
		</div>
		<div class="col-md-8" style="color: white; margin-bottom: 12px">
			<h2>${place}</h2>
		</div>
	</div>




	<c:forEach items="${data}" var="dw">
		
		<div class="row" style="color: black; margin-top: 50px" id="shoeweather">
			<div class="col-md-1">
			</div>
			<div class="col-md-1" style="text-align: center; background-color: white;">
				<h3><c:out value="${dw.getDay_part_name()}"></c:out></h3>		
			</div>
			<div class="col-md-2" style="background-color: white; background-color: white;">
				<h3><c:out value="${dw.getDate()}"></c:out></h3>
			</div>
			<!-- <div class="col-md-1" style="background-color: white; background-color: white;">
				<img src="images/sun.png" height="40" width="40" style="margin-top: 17px;" />
			</div> -->
			<div class="col-md-3" style="text-align: center; background-color: white;">
				<h3>Day :  <c:out value="${dw.getDaytemp()}"></c:out>C / Night : <c:out value="${dw.getNighttemp()}"></c:out>C</h3>
			</div>
			<div class="col-md-4" style="text-align: center;background-color: white;">
				<h3><c:out value="${dw.getShortcast()}"></c:out></h3>
			</div>
			<div class="col-md-1">
			</div>
		</div>



		<!-- <div class="row" style="color: white">
			<div class="col-md-2">
			</div>
			<div class="col-md-2" style="text-align: right; margin-top: 10px;">
				<c:out value="${dw.getDay_part_name()}"></c:out>		
			</div>
			<div class="col-md-6" style="text-align: left">
				<h2>
					<c:out value="${dw.getDate()}"></c:out>
				</h2>
				<c:out value="${dw.getShortcast()}"></c:out>
				<c:out value="${dw.getDaytemp()}"></c:out>
				<c:out value="${dw.getNighttemp()}"></c:out>
			</div>
			<div class="col-md-2">
			</div>
		</div> -->
<!-- <c:out value="${dw.getDate()}"></c:out>
<c:out value="${dw.getShortcast()}"></c:out>
<c:out value="${dw.getDay_part_name()}"></c:out>
<c:out value="${dw.getDaytemp()}"></c:out>
<c:out value="${dw.getNight_part_name()}"></c:out>
<c:out value="${dw.getNighttemp()}"></c:out>
======================================================================================================= -->
	</c:forEach>
</div>
</body>
</html>