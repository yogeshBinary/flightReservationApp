<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flights</title>
</head>
<body>
<h2>Flight search results</h2>
<h2>List of Flights</h2>
<table border="1">
	<tr>
		<th>Flight Number</th>
		<th>Airlines</th>
		<th>Departure City</th>
		<th>Arrival City</th>
		<th>Departure Time</th>
		<th>Select Flight</th>
	</tr>
		
	<c:forEach items="${findFlight}" var="findFlight">
		<tr>
			<td>${findFlight.flightNumber}</td>
			<td>${findFlight.operatingAirlines}</td>
			<td>${findFlight.departureCity}</td>
			<td>${findFlight.arrivalCity}</td>
			<td>${findFlight.estimatedDepartureTime}</td>
			<td><a href="showCompleteReservation?flightId=${findFlight.id}">Book</a></td>
		</tr>
	</c:forEach>
	
</table>	
</body>
</html>