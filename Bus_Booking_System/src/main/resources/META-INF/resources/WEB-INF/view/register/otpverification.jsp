<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="ISO-8859-1">
			<title>Otp Verification</title>
			<link rel="stylesheet"
				href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
			<style>
				<%@include file="/WEB-INF/view/base.css" %>
			</style>
		</head>

		<body>
			<div class="nav" id="navbar">
				<span class="logo">	
			<div id="mySidenav" class="sidenav">
				<div>
					<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
				</div>
				<a href="/login">Sign in</a><br><br>
				<a href="/register">Sign up</a><br>
			</div>
			<a href="javascript:void(0);" class="icon" onclick="openNav()">
					<i class="fa fa-bars"></i>
			</a>
		</span>
				<a href="/register" class="active" style="float: right;">Sign up</a>
				<a href="/login" class="right">Sign in</a>
			</div>
			<div style="padding: 5%;">
				<h1>Otp Verification</h1><hr>
				<p>Enter the OTP</p>
				<c:if test="${not empty error }">
					<p class="error">${error}</p>
				</c:if>
				<form action="/validate" method="post">
					<input type="number" maxlength="6" name="votp">&nbsp;&nbsp;&nbsp;
					<input type="submit" value="Verify OTP">
				</form>
			</div>
		</body>
		<script type="text/javascript">
		<%@include file="/WEB-INF/view/base.js" %>
	</script>
</html>