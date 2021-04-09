<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="navigate.html" %>
<h1 style="color: blue; text-align: center;">Logged In..</h1> <br>
 <h2 style="text-align: center;"> <%= session.getAttribute("uname") %> </h2>
<img src="/image/Map_of_USAState.png" width="40%"> </img>
</body>
</html>