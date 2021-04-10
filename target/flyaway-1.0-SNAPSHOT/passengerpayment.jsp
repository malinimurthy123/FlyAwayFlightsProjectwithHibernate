<%--
  Created by IntelliJ IDEA.
  User: krmal
  Date: 4/9/2021
  Time: 5:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>passenger payment page</title>
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

    <style>
        h1 {
            text-align: center;
            border-style: solid;
            color: black;
        }
    </style>

</head>
<body>
<h1>Enter passenger and Payment Details</h1>
<form name="bookingconfirmation" method="POST" action=bookingconfirmation>
    <LABEL>First Name :</LABEL><br><br>
     <input type="text" name="fname" placeholder="Prasad" required> <br/>

    <LABEL>Last Name :</LABEL><br><br>
     <input type="text" name="lname" placeholder="Murthy" required> <br><br>

    <LABEL>Credit Card Number:</LABEL><br><br>
    <input type="text" name="cardnumber" placeholder="7756 3456 8765 9987" required> <br><br>

    <LABEL>CVV Number :</LABEL><br><br>
    <input type="number" name="securitycode" placeholder="000" required> <br><br>
    <br/>

    <LABEL>Expiration (yyyy-MM-dd)</LABEL><br><br>
    <input type="date" name="expiration" placeholder="2024-10-31"  required> <br><br>

    <LABEL>Total Passengers</LABEL><br><br>
    <input type="text" name="totalpassengers" placeholder="1"  required> <br><br>

    <button type="button" class="btn btn-info" onclick="addpet_onclick()">Continue to confirm booking</button>

</form>
</body>
</html>
