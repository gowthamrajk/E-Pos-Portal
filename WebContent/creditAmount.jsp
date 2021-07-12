<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Credit</title>
<link href="creditStyle.css" rel="stylesheet">
<link rel="shortout icon" type="image/x-icon" href="images/credit.png">
<meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
</head>
<body>
<div class="testbox1">
<div class="testbox2">
  <h1>Credit Amount</h1></div>
  <form action="creditAmountServlet" method="post">
  <hr>
  <br>
  <center><h3>Account Number</h3>
  <input type="text" name="acc_no" id="name" placeholder="account number" required/>
  <br>
  <br><p><h3>Credit Amount</h3></p>
  <input type="text" name="credit_amount" id="name" placeholder="amount in INR" required/>
  <br>
   <input type="submit" class="button" value="Credit"><center>
  </form>
</div>
<div class="testbox3">
<img src="images/creditCard.gif" width="343px" height="370px">
</div>
</body>
</html>