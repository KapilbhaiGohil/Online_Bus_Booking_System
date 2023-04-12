<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bushes</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<style>
	<%@include file="/WEB-INF/view/base.css" %>
</style>
<style>
	p{
		align-items: center;
	}
	button{
		position: relative;
    	top: 40%;
	}
	input[type=button]{
		padding: 10px;
    	margin: 5px 0 22px 0;
    	display: inline-block;
    	border: none;
    	background: #f1f1f1;
   	 	border-radius: 10px;
        font-weight: bolder;
    	color: #f2f2f2;
    	text-decoration: none;
        background-color: #04AA6D;
    	cursor: pointer;
    	width: 30%;
    	position: inherit;
	}
	img{
		width:20px;
		height:23px;
	}
	/* #sleeperimg{
		width: 45px;
		height: 20px;
		cursor: pointer;
	} */
	#created{
		display:inline;
	}
	#selecteseat{
	display:inline}
	h4{
		 background-color: #4677af;
		 color:#ccc;
		 padding:10px;
	}

</style>
<body>
	<div class="nav" id="navbar">
		<span class="logo">	
			<div id="mySidenav" class="sidenav">
				<div>
					<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
				</div>
					<a href="home">Home</a><br>
					<a href="logout">Log out</a><br>
					<a href="checkticket">see your tickets</a><br>
					
			</div>
			<a href="javascript:void(0);" class="icon" onclick="openNav()">
					<i class="fa fa-bars"></i>
			</a>
			<a href="home">Home</a><br>
		</span>
        <p style="float:right;padding-right:20px;color:#f2f2f2;margin-top:0px;">Hello ${loginstatus.first_name}</p>
    </div>
    <div style="padding:5%;">
    	<h1>Total Trips Availabile ${volvo.size()+sleeper.size()+express.size()+luxary.size()}</h1><hr>
    	<p></p><br>
    	<c:choose>
		<c:when test="${empty loginstatus}">
			<c:redirect url="login"></c:redirect>
		</c:when>
		<c:otherwise>
				<c:choose>
					<c:when test="${not empty boo}">
						<div><h4><font>${so.name}</font> - <font>${dest.name}</font> <font style="float: right;">${jourdate}</font></h4></div>
						<!-- sleeper bushes design are here -->
						<c:if test="${sleeper.size()>0}">						
						<p style="margin-left: 0px;    margin-top: 20px;    font-weight: bold;    color: #ff6633;">Sleeper, Total Trips : ${sleeper.size()}</p>
						</c:if>
						<c:forEach items="${sleeper}" var="item">
							<div  style="border: solid black 1px;">
								<div style="display: grid; grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr 1fr ;">
									<div>
										<p style="color: #a21818;font-weight:bolder;">${item.name}</p>
									</div>
									<div>
										<b><p style="color:#ccc;">Dept. Time</p></b>
										<p>${item.route.depttime}</p>
									</div>
									<div>
										<b><p style="color:#ccc;">Origin</p></b>
										<p>${item.route.stations.get(0).name}</p>
									</div>
									<div>
										<b><p style="color:#ccc;">Destination</p></b>
										<p>${item.route.stations.get(item.route.stations.size()-1).name}</p>
									</div>
									<div>
										<b><p style="color:#ccc;">Duration</p></b>
										<p>${duvolu}</p>
									</div>
									
									<div>
										<b><p style="color:#ccc;">Fare</p></b>
										<p style="color: #006600;    font-weight: bold;">&#8377;${item.priceperseat}</p>
									</div>
									<div>
										<button type = "button" style="position: inherit;border-radius: 4px;    background-color: #4677af;    border: none;    color: #fff;    text-align: center;    font-size: 14px;   width: 60px;    transition: all 0.5s;  cursor: pointer;margin-top: 22px;" onclick="hideshow(${item.id},${noseat})">Select Seat/s</button>
									</div>
								</div>
								<div id="${item.id}" name="change" style="display: none;grid-template-columns: 1.5fr 1fr;padding: 10px;">
									<div style="height:210px;display: grid;grid-template-columns: 1fr 10fr;border: solid black 1px;padding-top: 3%;">
										<div>
											<img width="18" height="20" src="https://gsrtc.in/OPRSOnline/images2/busSteering_icon1.gif" alt="">
										</div>
										<div style="display: grid; grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr;grid-template-rows: 1fr 1.8fr;">
											<c:set var="count" value="1" scope="request" />
											<c:forEach  items="${item.seats}" var="seat">
											<div style=" text-align-last: center;display: inline-block;height: 20%;">
												<c:if test="${seat}">
												<img id="sleeperimg" style="width: 45px;height: 20px;cursor: pointer;" src="https://gsrtc.in/OPRSOnline/images2/Sleeper-Seat_Booked.gif" alt="">
												<div style="text-align-last: center;height: 5px;">
													<p style="margin: 0px 0px 0px 0px;font-size:9px;">${count}</p>
												</div>
												</c:if>
												<c:if test="${not seat}">
												<img id="sleeperimg" style="width: 45px;height: 20px;cursor: pointer;" class="undoeffect" onclick="changeToBW(${count},${item.id},${noseat})" title="${count}" src="https://gsrtc.in/OPRSOnline/images2/Sleeper-Seat_Available.gif" alt="">
												<div style="text-align-last: center;    height: 5px;">
													<p style="margin: 0px 0px 0px 0px;font-size:9px;">${count}</p>
												</div>
												</c:if>
												<c:set var="count" value="${count + 1}" scope="request"/><br>
											</div>
											</c:forEach>
											
										</div>
									
									</div>
									<div style = "padding:10px">
										<form action="/seatbook" method = "post" id="bookform">
											<p id='selecteseat'>Selected Seats. : </p><br>
											<input type="hidden" required name="busid" value="${item.id}">
											<input type="hidden" required name="price" value="${item.priceperseat}">
											<input type="hidden" required name="jourdate" value="${jourdate}">
											<input type="hidden" required name="type" value="sleeper"><br>
											<label for="email" >Email Id :</label>&nbsp;&nbsp;&nbsp;
											<input type="email" disabled value="${loginstatus.email}" style="width:30%;" required name="email"><br>
											<label for="mobile">Mobile No : </label>
											<input type="text" maxlength="10" style="width:30%;" name="mobile"><br>
											<input type="text" required name="from" disabled value="${so.name}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											To&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<input type="text" required name="to" disabled value="${dest.name}">
											<p>Person Details : </p>
											 <c:forEach var = "i" begin = "1" end = "${noseat}">
										         <input type="text" required placeholder="Name" name="name">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										         <input type="text" required style="width: 10%;" placeholder="Age" name="age">&nbsp;&nbsp;&nbsp;
										         <select name="gender" required id="">
													<option value="Male" >Male</option>
													<option value="Female">Female</option>
												 </select><br>
										     </c:forEach>
											<br><input onclick=" return  formsubmit(${item.id},${noseat })" type="submit" id="booknow" Value= "Book">
										</form>
									</div>
								</div>
							</div><br><br><br>
					</c:forEach>




					<!-- Volvo bushes are here -->
					<c:if test="${volvo.size()>0}">					
					<p style="margin-left: 0px;    margin-top: 20px;    font-weight: bold;    color: #ff6633;">Volvo, Total Trips : ${volvo.size()}</p>
					</c:if>
						<c:forEach items="${volvo}" var="item">
							<div  style="border: solid black 1px;">
								<div style="display: grid; grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr 1fr ;">
									<div>
										<p style="color: #a21818;font-weight:bolder;">${item.name}</p>
									</div>
									<div>
										<b><p style="color:#ccc;">Dept. Time</p></b>
										<p>${item.route.depttime}</p>
									</div>
									<div>
										<b><p style="color:#ccc;">Origin</p></b>
										<p>${item.route.stations.get(0).name}</p>
									</div>
									<div>
										<b><p style="color:#ccc;">Destination</p></b>
										<p>${item.route.stations.get(item.route.stations.size()-1).name}</p>
									</div>
									<div>
										<b><p style="color:#ccc;">Duration</p></b>
										<p>${duvolu}</p>
									</div>
									
									<div>
										<b><p style="color:#ccc;">Fare</p></b>
										<p style="color: #006600;    font-weight: bold;">&#8377;${item.priceperseat}</p>
									</div>
									<div>
										<button type = "button" style="position: inherit;border-radius: 4px;    background-color: #4677af;    border: none;    color: #fff;    text-align: center;    font-size: 14px;   width: 60px;    transition: all 0.5s;  cursor: pointer;margin-top: 22px;" onclick="hideshow(${item.id},${noseat})">Select Seat/s</button>
									</div>
								</div>
								<div id="${item.id}" name="change" style="display: none;grid-template-columns: 1.5fr 1fr;padding: 10px;">
									<div style="height:210px;display: grid;grid-template-columns: 1fr 10fr;border: solid black 1px;padding-top: 3%;">
										<div>
											<img width="18" height="20" src="https://gsrtc.in/OPRSOnline/images2/busSteering_icon1.gif" alt="">
										</div>
										<div style="display: grid; grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr;grid-template-rows: 1fr 1.8fr;">
											<c:set var="count" value="1" scope="request" />
											<c:forEach  items="${item.seats}" var="seat">
											<div style=" text-align-last: center;display: inline-block;height: 20%;">
												<c:if test="${seat}">
												<img id="sleeperimg" style="width: 20px;height: 23px;cursor: pointer;" src="https://gsrtc.in/OPRSOnline/images2/bookedSeatnew.gif" alt="">
												<div style="text-align-last: center;height: 5px;">
													<p style="margin: 0px 0px 0px 0px;font-size:9px;">${count}</p>
												</div>
												</c:if>
												<c:if test="${not seat}">
												<img width="30" style="width: 20px;height: 23px;cursor: pointer;" height="20" id="sleeperimg" class="undoeffect" onclick="changeToBW(${count},${item.id},${noseat})" title="${count}" src="https://gsrtc.in/OPRSOnline/images2/availableSeatnew.gif" alt="">
												<div style="text-align-last: center;    height: 5px;">
													<p style="margin: 0px 0px 0px 0px;font-size:9px;">${count}</p>
												</div>
												</c:if>
												<c:set var="count" value="${count + 1}" scope="request"/><br>
											</div>
											</c:forEach>
											
										</div>
									
									</div>
									<div style = "padding:10px">
										<form action="/seatbook" method = "post" id="bookform">
											<p id='selecteseat'>Selected Seats. : </p><br>
											<input type="hidden" required name="busid" value="${item.id}">
											<input type="hidden" required name="price" value="${item.priceperseat}">
											<input type="hidden" required name="jourdate" value="${jourdate}">
											<input type="hidden" required name="type" value="volvo"><br>
											<label for="email" >Email Id :</label>&nbsp;&nbsp;&nbsp;
											<input type="email" disabled value="${loginstatus.email}" style="width:30%;" required name="email"><br>
											<label for="mobile">Mobile No : </label>
											<input type="text" maxlength="10" style="width:30%;" name="mobile"><br>
											<input type="text" required name="from" disabled value="${so.name}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											To&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<input type="text" required name="to" disabled value="${dest.name}">
											<p>Person Details : </p>
											 <c:forEach var = "i" begin = "1" end = "${noseat}">
										         <input type="text" required placeholder="Name" name="name">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										         <input type="text" required style="width: 10%;" placeholder="Age" name="age">&nbsp;&nbsp;&nbsp;
										         <select name="gender" required id="">
													<option value="Male" >Male</option>
													<option value="Female">Female</option>
												 </select><br>
										     </c:forEach>
											<br><input onclick=" return  formsubmit(${item.id},${noseat })" type="submit" id="booknow" Value= "Book">
										</form>
									</div>
								</div>
							</div><br><br><br>
					</c:forEach>




					<!-- Luxary bushes are here -->
					<c:if test="${luxary.size()>0}">					
					<p style="margin-left: 0px;    margin-top: 20px;    font-weight: bold;    color: #ff6633;">Luxary, Total Trips : ${luxary.size()}</p>
					</c:if>
						<c:forEach items="${luxary}" var="item">
							<div  style="border: solid black 1px;">
								<div style="display: grid; grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr 1fr ;">
									<div>
										<p style="color: #a21818;font-weight:bolder;">${item.name}</p>
									</div>
									<div>
										<b><p style="color:#ccc;">Dept. Time</p></b>
										<p>${item.route.depttime}</p>
									</div>
									<div>
										<b><p style="color:#ccc;">Origin</p></b>
										<p>${item.route.stations.get(0).name}</p>
									</div>
									<div>
										<b><p style="color:#ccc;">Destination</p></b>
										<p>${item.route.stations.get(item.route.stations.size()-1).name}</p>
									</div>
									<div>
										<b><p style="color:#ccc;">Duration</p></b>
										<p>${duvolu}</p>
									</div>
									
									<div>
										<b><p style="color:#ccc;">Fare</p></b>
										<p style="color: #006600;    font-weight: bold;">&#8377;${item.priceperseat}</p>
									</div>
									<div>
										<button type = "button" style="position: inherit;border-radius: 4px;    background-color: #4677af;    border: none;    color: #fff;    text-align: center;    font-size: 14px;   width: 60px;    transition: all 0.5s;  cursor: pointer;margin-top: 22px;" onclick="hideshow(${item.id},${noseat})">Select Seat/s</button>
									</div>
								</div>
								<div id="${item.id}" name="change" style="display: none;grid-template-columns: 1.5fr 1fr;padding: 10px;">
									<div style="height:240px;display: grid;grid-template-columns: 1fr 10fr;border: solid black 1px;padding-top: 3%;">
										<div>
											<img width="18"  height="20"  src="https://gsrtc.in/OPRSOnline/images2/busSteering_icon1.gif" alt="">
										</div>
										<div style="display: grid; grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr;grid-template-rows: 1fr 1.8fr;">
											<c:set var="count" value="1" scope="request" />
											<c:forEach  items="${item.seats}" var="seat">
											<div style=" text-align-last: center;display: inline-block;height: 20%;">
												<c:if test="${seat}">
												<img id="sleeperimg" style="width: 20px;height: 23px;cursor: pointer;" src="https://gsrtc.in/OPRSOnline/images2/bookedSeatnew.gif" alt="">
												<div style="text-align-last: center;height: 5px;">
													<p style="margin: 0px 0px 0px 0px;font-size:9px;">${count}</p>
												</div>
												</c:if>
												<c:if test="${not seat}">
												<img id="sleeperimg" style="width: 20px;height: 23px;cursor: pointer;" class="undoeffect" onclick="changeToBW(${count},${item.id},${noseat})" title="${count}" src="https://gsrtc.in/OPRSOnline/images2/availableSeatnew.gif" alt="">
												<div style="text-align-last: center;    height: 5px;">
													<p style="margin: 0px 0px 0px 0px;font-size:9px;">${count}</p>
												</div>
												</c:if>
												<c:set var="count" value="${count + 1}" scope="request"/><br>
											</div>
											</c:forEach>
											
										</div>
									
									</div>
									<div style = "padding:10px">
										<form action="/seatbook" method = "post" id="bookform">
											<p id='selecteseat'>Selected Seats. : </p><br>
											<input type="hidden" required name="busid" value="${item.id}">
											<input type="hidden" required name="price" value="${item.priceperseat}">
											<input type="hidden" required name="jourdate" value="${jourdate}">
											<input type="hidden" required name="type" value="luxary"><br>
											<label for="email" >Email Id :</label>&nbsp;&nbsp;&nbsp;
											<input type="email" disabled value="${loginstatus.email}" style="width:30%;" required name="email"><br>
											<label for="mobile">Mobile No : </label>
											<input type="text" maxlength="10" style="width:30%;" name="mobile"><br>
											<input type="text" required name="from" disabled value="${so.name}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											To&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<input type="text" required name="to" disabled value="${dest.name}">
											<p>Person Details : </p>
											 <c:forEach var = "i" begin = "1" end = "${noseat}">
										         <input type="text" required placeholder="Name" name="name">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										         <input type="text" required style="width: 10%;" placeholder="Age" name="age">&nbsp;&nbsp;&nbsp;
										         <select name="gender" required id="">
													<option value="Male" >Male</option>
													<option value="Female">Female</option>
												 </select><br>
										     </c:forEach>
											<br><input onclick=" return  formsubmit(${item.id},${noseat })" type="submit" id="booknow" Value= "Book">
										</form>
									</div>
								</div>
							</div><br><br><br>
					</c:forEach>




					<!-- Express bushes are here -->
					<c:if test="${express.size()>0}">					
					<p style="margin-left: 0px;    margin-top: 20px;    font-weight: bold;    color: #ff6633;">Express, Total Trips : ${express.size()}</p>
					</c:if>
						<c:forEach items="${express}" var="item">
							<div  style="border: solid black 1px;">
								<div style="display: grid; grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr 1fr ;">
									<div>
										<p style="color: #a21818;font-weight:bolder;">${item.name}</p>
									</div>
									<div>
										<b><p style="color:#ccc;">Dept. Time</p></b>
										<p>${item.route.depttime}</p>
									</div>
									<div>
										<b><p style="color:#ccc;">Origin</p></b>
										<p>${item.route.stations.get(0).name}</p>
									</div>
									<div>
										<b><p style="color:#ccc;">Destination</p></b>
										<p>${item.route.stations.get(item.route.stations.size()-1).name}</p>
									</div>
									<div>
										<b><p style="color:#ccc;">Duration</p></b>
										<p>${duvolu}</p>
									</div>
									
									<div>
										<b><p style="color:#ccc;">Fare</p></b>
										<p style="color: #006600;    font-weight: bold;">&#8377;${item.priceperseat}</p>
									</div>
									<div>
										<button type = "button" style="position: inherit;border-radius: 4px;    background-color: #4677af;    border: none;    color: #fff;    text-align: center;    font-size: 14px;   width: 60px;    transition: all 0.5s;  cursor: pointer;margin-top: 22px;" onclick="hideshow(${item.id},${noseat})">Select Seat/s</button>
									</div>
								</div>
								<div id="${item.id}" name="change" style="display: none;grid-template-columns: 1.5fr 1fr;padding: 10px;">
									<div style="height:290px;display: grid;grid-template-columns: 1fr 10fr;border: solid black 1px;padding-top: 3%;">
										<div>
											<img width="18" height="20" src="https://gsrtc.in/OPRSOnline/images2/busSteering_icon1.gif" alt="">
										</div>
										<div style="display: grid; grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr;grid-template-rows: 1fr 1fr 1.8fr;">
											<c:set var="count" value="1" scope="request" />
											<c:forEach  items="${item.seats}" var="seat">
											<div style=" text-align-last: center;display: inline-block;height: 20%;">
												<c:if test="${seat}">
												<img id="sleeperimg" style="width: 20px;height: 23px;cursor: pointer;" src="https://gsrtc.in/OPRSOnline/images2/bookedSeatnew.gif" alt="">
												<div style="text-align-last: center;height: 5px;">
													<p style="margin: 0px 0px 0px 0px;font-size:9px;">${count}</p>
												</div>
												</c:if>
												<c:if test="${not seat}">
												<img id="sleeperimg" style="width: 20px;height: 23px;cursor: pointer;" class="undoeffect" onclick="changeToBW(${count},${item.id},${noseat})" title="${count}" src="https://gsrtc.in/OPRSOnline/images2/availableSeatnew.gif" alt="">
												<div style="text-align-last: center;    height: 5px;">
													<p style="margin: 0px 0px 0px 0px;font-size:9px;">${count}</p>
												</div>
												</c:if>
												<c:set var="count" value="${count + 1}" scope="request"/><br>
											</div>
											</c:forEach>
											
										</div>
									
									</div>
									<div style = "padding:10px">
										<form action="/seatbook" method = "post" id="bookform">
											<p id='selecteseat'>Selected Seats. : </p><br>
											<input type="hidden" required name="busid" value="${item.id}">
											<input type="hidden" required name="price" value="${item.priceperseat}">
											<input type="hidden" required name="jourdate" value="${jourdate}">
											<input type="hidden" required name="type" value="express"><br>
											<label for="email" >Email Id :</label>&nbsp;&nbsp;&nbsp;
											<input type="email" disabled value="${loginstatus.email}" style="width:30%;" required name="email"><br>
											<label for="mobile">Mobile No : </label>
											<input type="text" maxlength="10" style="width:30%;" name="mobile"><br>
											<input type="text" required name="from" disabled value="${so.name}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											To&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<input type="text" required name="to" disabled value="${dest.name}">
											<p>Person Details : </p>
											 <c:forEach var = "i" begin = "1" end = "${noseat}">
										         <input type="text" required placeholder="Name" name="name">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										         <input type="text" required style="width: 10%;" placeholder="Age" name="age">&nbsp;&nbsp;&nbsp;
										         <select name="gender" required id="">
													<option value="Male" >Male</option>
													<option value="Female">Female</option>
												 </select><br>
										     </c:forEach>
											<br><input onclick=" return  formsubmit(${item.id},${noseat })" type="submit" id="booknow" Value= "Book">
										</form>
									</div>
								</div>
							</div><br><br><br>
					</c:forEach>



					
					</c:when>
					<c:otherwise>
					<c:redirect url="home"></c:redirect>
					</c:otherwise>
				</c:choose>
		</c:otherwise>
</c:choose>
    </div>
    <script type = "text/javascript" >  
    function preventBack() { window.history.forward(); }  
    setTimeout("preventBack()", 0);  
    window.onunload = function () { null };  
</script> 
    <script type="text/javascript">
    	
		<%@include file="/WEB-INF/view/base.js" %>
	</script>
</body>
</html>