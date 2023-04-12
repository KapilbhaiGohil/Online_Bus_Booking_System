<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log in</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<style>
	<%@include file="/WEB-INF/view/base.css" %>
</style>
<body>
	<c:choose>
	<c:when test="${not empty loginstatus}">
	<c:redirect url="home"></c:redirect>
	</c:when>
	<c:otherwise>
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
        <a href="/register" class="right">Sign up</a>
        <a href="/login" class="active" style="float:right;">Sign in</a>
    </div>
    <div style="padding: 5%;">
			<h1>Log in</h1><hr style="">
			<p>Enter the login details</p>
		<c:if test="${not empty loginerror}">
		<p class="error">${loginerror}</p>
		</c:if>
	    <form action="" method="post">
			<label for="username">Username</label><br>
	        <input type="text" required name="username" id=""><br>
			<label for="password">Password</label><br>
	        <input type="password" required name="password" id=""><br>
	        <p>Don't have an account? <a href="/register">Register here</a></p>
	        <p>Click here if you <a href="/forgotpass">Forgotten your password</a></p>
	        <input type="submit" name="" id="" value="Sign in">
	    </form>
	</div>
	</c:otherwise>
	</c:choose>
	<script type="text/javascript">
		<%@include file="/WEB-INF/view/base.js" %>
	</script>
</body>
</html>