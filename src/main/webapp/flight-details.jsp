<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="entity.flightdetail" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.flyaway.HibernateUtil" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="java.io.PrintWriter" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<!-- Datepicker -->
<link href='bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css' rel='stylesheet' type='text/css'>
<script src='bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js' type='text/javascript'></script>
<meta name="viewport" content="width=device-width, initial-scale=2">
<title>Flight search Details</title>
<style>
	table, td, th, h1 {
		align-content: center;
		border: 2px solid gray;
		padding: 5px;
		margin-left: auto;
		margin-right: auto;
	}

	th {
		background-color: #4287f5;
		color: white;
	}
	<style>
	.img-container {
	text-align: center;
	display: block;
	}
	</style>
</style>
</head>
<body>
<h1>Flight Search Results</h1>
<form method="post" action="passengerpayment.jsp"">
<table>
			<tr>
			<th>Source</th>
			<th>Destination</th>
			<th>Airline</th>
			<th>Ticket Price</th>
			</tr>


	<%

		String driver = "com.mysql.jdbc.Driver";
		String connectionUrl = "jdbc:mysql://localhost:3306/";
		String database = "flyawayflight";
		String userid = "root";
		String password = "";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

	%>

	<%
		try{
			connection = DriverManager.getConnection(connectionUrl+database, userid, password);
			statement=connection.createStatement();
			String sql ="select * from flightdetail";
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
	%>
	<tr>
		<td><%=resultSet.getString("flight_id") %></td>
		<td><%=resultSet.getString("source") %></td>
		<td><%=resultSet.getString("destination") %></td>
		<td><%=resultSet.getString("price") %></td>
		<td><%=resultSet.getString("date") %></td>
		<td><button value="submit" href="passengerPayment.html">continue with booking</button></td>

		<br>

	</tr>
	<%
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
<br>
<%
	out.print("<td>" +"Flight Search Information searched from Home Page"+"</td>");

%>
<%

	out.print("<td>" +request.getParameter("source"));
	out.print("<td>" +request.getParameter("destination"));
	out.print("<td>" +request.getParameter("travellers"));
	out.print("<td>" +request.getParameter("date"));

%>


<c:forEach var="flight1" items="${listFlight}">
	<tr>
	<td><c:out value="${flight1.source}"/></td>
	<td><c:out value="${flight1.destination}"/></td>
	<td><c:out value="${flight1.travellers}"/></td>
	<td><c:out value="${flight1.date}"/></td>

	</tr>


	<a href="edit?id=<c:out value='${user.id}' />">Edit</a>
</c:forEach>

</table>
<Div>

	<img src="Map_of_USA.png" height="303" width="780"/>
	<img src="How-to-find.jpg" height="303" width="780"/>

</Div>

</body>
</html>