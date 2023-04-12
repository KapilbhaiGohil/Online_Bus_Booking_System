<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>basic</title>
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
        <a href="/register" class="" style="float:right;">Sign up</a>
        <a href="/login" class="right">Sign in</a>
    </div>
    <div style="padding:5%;">
	
	
    <c:choose>
    <c:when test="${not empty loginstatus}">
	<c:redirect url="home"></c:redirect>
	</c:when>
	<c:otherwise>
		<c:choose>
		<c:when test="${not empty verify }">
		<h1>Set New Password</h1><hr>
		<p>Enter the new password you want to set</p><br>
		<c:if test="${not empty error }">
		<p class="error">${error}</p>
		</c:if>
		<form method = "post" action = "/changepass">
		<label for="pass1">Password</label><br>
		<input type="text" name="pass1"><br>
		<label for="pass2">conform password</label><br>
		<input type="text" name="pass2"><br>
		<input type='submit' value= "Submit">
		</form>
		</c:when>
		<c:otherwise>	
		<h1>Email</h1><hr>
		<p>Enter the email with which your account is registerd</p>
		<c:if test="${not empty error }">
		<p class="error">${error}</p>
		</c:if>
		<form method = "post" action = "/forgotpass">
		<label for="email" >Email</label><br>
		<input type="email" required name="email">&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='submit' value= "Get OTP">
		</form>
		</c:otherwise>
		</c:choose>
	</c:otherwise>
    </c:choose>
    </div>
    <script type="text/javascript">
		<%@include file="/WEB-INF/view/base.js" %>
	</script>
</body>
</html>