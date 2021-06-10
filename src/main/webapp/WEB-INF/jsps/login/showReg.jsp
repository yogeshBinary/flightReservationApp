<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.submit {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
}

.submit {
  background-color: white; 
  color: black; 
  border: 2px solid #4CAF50;
}

.submit:hover {
  background-color: #4CAF50;
  color: white;
}

input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
input[type=password], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}
form {
    margin-left: 25%;
    margin-right:25%;
    width: 50%;
}
h2 {
    margin-left: 25%;
    margin-right:25%;
    width: 50%;
}
form label.required:after
{
    color: red;
    content: " *";
}

form input[required=required]:after,
form select[required=required]:after,
form textarea[required=required]:after
{
    color: red;
    content: " *";
}

</style>
<script type="text/javascript">
function myFunction() {
	  var x = document.getElementById("myInput");
	  if (x.type === "password") {
	    x.type = "text";
	  } else {
	    x.type = "password";
	  }
	}
</script>
<meta charset="ISO-8859-1">
<title>New Registration</title>
</head>
<body>
<h2>Create new Account</h2>
	<form action="showLogin" method="post">
		<table >
			
				<tr>
				<td><label class="control-label required" for="firstName">First Name</label></td>
				 
				<td><input type="text" name="firstName" required="required"></td>
				</tr>
				<tr>
				<td><label class="control-label required" for="lastName">Last Name</label></td>
				<td><input type="text" name="lastName" required="required"></td>
				</tr>
				<tr>
				<td><label class="control-label required" for="email">Email</label></td>
				<td><input type="text" name="email" required="required"></td>
				</tr>
				<tr>
				<td><label class="control-label required" for="password">Password</label></td>
				<td><input type="password" name="password" required="required" id="myInput"></td>
				<td><input type="checkbox" onclick="myFunction()">Show Password</td>
				</tr>		
				<tr>
				<td><input type="submit" class="submit" value="save"></td>
				</tr>
			
		</table>
	</form><br>
	${msg}
</body>
</html>