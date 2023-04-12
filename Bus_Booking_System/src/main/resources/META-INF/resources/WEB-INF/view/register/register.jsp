<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% response.setHeader("cache-Control","no-cache,no-store,must-revalidate"); 
response.setHeader("Pragma","no-cache");    
response.setHeader("Expires","0"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<style>
		<%@include file="/WEB-INF/view/base.css" %>
</style>
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
        <a href="/register" class="active" style="float:right;">Sign up</a>
        <a href="/login" class="right">Sign in</a>
    </div>
	<c:choose>
	<c:when test="${not empty loginstatus}">
	<c:redirect url="home"></c:redirect>
	</c:when>
	<c:otherwise>
		<div style="padding: 5%;">
			<h1>Creat An Account</h1><hr style="">
			<p>Pls fill this form for the creating new account</p>
			<c:if test="${not empty error}">
				<p class="error">${error}</p>
			</c:if>
			<form action="/validate" method="post">
				<label for="username">Username</label><br>
				<input type="text" required name="username" value="${user.username}"><br>
				<label for="firstname">First Name</label><br>
				<input type="text" required name="firstname" id="" value="${user.first_name}"> <br>
				<label for="lastname">Last Name</label><br>
				<input type="text" required name="lastname" id="" value="${user.last_name}"> <br>
				<label for="email">Email</label><br>
				<input type="email" required name="email" id="" value="${user.email}"> <br> 
				<label for="password">Password</label><br>
				<input type="password" required name="password"> <br>
				<label for="cpassword">Conform Your Password</label><br>
				<input type="password" required name="cpassword"> <br>
				<input type="submit" required name="submit" id="" value="Submit">
			</form>
		</div>
	</c:otherwise>
	</c:choose>
	<script type="text/javascript">
		<%@include file="/WEB-INF/view/base.js" %>
	</script>
</body>
</html>