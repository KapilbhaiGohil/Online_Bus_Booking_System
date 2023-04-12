<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<meta charset="ISO-8859-1">
<title>Bill</title>
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
					<a href="logout">Log out</a><br>
					<a href="checkticket">see your tickets</a><br>
						
			</div>
			<a href="javascript:void(0);" class="icon" onclick="openNav()">
					<i class="fa fa-bars"></i>
			</a>
			<a href="home">Home</a><br>
		</span>
                <p style="float:right;margin-left:1350px;margin-top:16px;padding-right:20px;color:#f2f2f2;">Hello ${loginstatus.first_name}</p>
    </div>
    <div style="padding:5%;">
    	<h1>Ticket Information</h1><hr>
    		<table class="table table-hover">
        <thead>
          <tr>
            <th scope="col">Ticket Id</th>
            <th scope="col">Source</th>
            <th scope="col">Destination</th>
            <th scope="col">Date</th>
            <th scope="col">Price</th>
            <th scope="col">Seat/s no/s</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${Bookings}" var="i">        
          <tr>
            <th scope="row">${i.id}</th>
            <td>${i.source }</td>
            <td>${i.destination}</td>
            <td>${i.journydate}</td>
            <td>&#8377; ${i.total_price}</td>
            <td>
            <c:forEach items="${i.seatno}" var="arr">
            ${arr}, 
            </c:forEach>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    	<p></p><br>
    </div>
    <script type="text/javascript">
		<%@include file="/WEB-INF/view/base.js" %>
	</script>

</body>
</html>