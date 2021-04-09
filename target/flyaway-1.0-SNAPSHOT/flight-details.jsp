<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="entity.flightdetail" %>
<%@ page import="entity.airlines" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>

<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Details</title>
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
</style>
</head>
<body>
<h1>Flight Search Results</h1>
<table>
<tr>
<th>Source</th>
<th>Destination</th>
<th>Airline</th>
<th>Ticket Price</th>
</tr>
	<%
		out.print(request.getParameter("source"));
		out.print(request.getParameter("destination"));
		out.print(request.getParameter("travellers"));
		out.print(request.getParameter("date"));

	%>
</table>
</body>
</html>