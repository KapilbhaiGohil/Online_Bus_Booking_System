<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sucess</title>
</head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
    <div style="padding: 5%;">
        <h1>Account Status</h1><hr>
	<p>${error}</p>
	<p>Your account has been successfully created </p>
    you can <a href="/login">log in here</a>
    </div>
    <script type="text/javascript">
		<%@include file="/WEB-INF/view/base.js" %>
	</script>
</body>
</html>