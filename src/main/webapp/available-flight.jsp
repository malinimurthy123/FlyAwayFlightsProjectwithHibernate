<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Get Avilable Flights</title>
<style type="text/css">
a{

color: #0b4f09;
}
</style>
</head>
<body>
<h3>
<a href="index.html">Home</a> 
</h3>
<fieldset style="background-color: whitesmoke;" >
<legend style="text-align: center; "><h1>Flight Details</h1></legend>
<form method="post" action="AvailableFlights">
<label style="font-size: 40px;">Select Airline</label>
<select id="airline" name="airline" style="max-width: 80%">
<option style="">Airlines -  Price</option>
<option value="1"><p>Delta -</p><p> 1200.00</p></option>
<option value="2"><p>Southwest -</p><p> 2000.00</p></option>
<option value="3"><p>Alaska    -</p><p> 1700.00</p></option>
<option value="4"><p>Spirit   -</p><p> 3456.00</p></option>
<option value="5"><p>JetBlue  -</p><p> 900.00</p></option>
<option value="6"><p>AmericanAirlines  -</p><p> 5678.00</p></option>
</select>
<button value="submit">Submit</button>

    <img src="image/Map_of_USAState.png" width="40%"> </img>
</form>
</fieldset>
</body>
</html>