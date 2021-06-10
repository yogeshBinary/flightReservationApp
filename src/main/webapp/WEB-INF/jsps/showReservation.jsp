<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation</title>
</head>
<body>
<script type="text/javascript">
	 function validate(){
			var val = number.value
			if (/^\d{10}$/.test(val)) {
			    // value is ok, use it
			} else {
			    alert("Invalid number; must be ten digits")
			    number.focus()
			    return false
			}
			
		}
</script>

<h2>Flight details </h2>
	<table>
		<tr>
		<td>Flight Number:</td>
		<td>${flight.flightNumber}</td>
		</tr>
		
		<tr>
		<td>Operating Airlines:</td>
		<td>${flight.operatingAirlines}</td>
		</tr>
		
		<tr>
		<td>Departure City</td>
		<td>:${flight.departureCity}</td>
		</tr>
		
		<tr>
		<td>Arrival City:</td>
		<td>${flight.arrivalCity}</td>
		</tr>
		
		<tr>
		<td>Departure Date:</td>
		<td>${flight.dateOfDeparture}</td>
		</tr>	

			
	</table>
	<h2>Enter Passenger details </h2>
		<form action="completeReservation" onsubmit="return validate()" method="post">
			<table>
							
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="firstName"></td>
				</tr>			
				<tr>	
					<td>Last Name:</td>
					<td><input type="text" name="lastName"></td>
				</tr>			
				<tr>	
					<td>Middle Name:</td>
					<td><input type="text" name="middleName"></td>
				</tr>			
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email"></td>
				</tr>			
				<tr>
					<td>Phone:</td>
					<td><input type="text" name="phone" id="number"></td>
				</tr>
				<tr><td><h2>Enter your card details</h2></td></tr>
				<tr>
					<td>Name on the card:</td>
					<td><input type="text" name="nameOnTheCard"></td>
				</tr>			
				<tr>
					<td>Card Number:</td>
					<td><input type="text" name="cardNumber"></td>
				</tr>
				<tr>
					<td>CVV:</td>
					<td><input type="text" name="cvv"></td>
				</tr>
				<tr>
					<td>Expire Date:</td>
					<td><input type="text" name="expireDate"></td>
				</tr>
				<tr> 
				<td><input type="hidden" name="id" value="${flight.id}"></td>
				</tr>
				<tr>
					<td><input type="submit" value="complete reservation" ></td>
				</tr>
				
			</table>
		</form>
</body>
</html>