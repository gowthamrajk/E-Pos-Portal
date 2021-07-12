<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Debit</title>
<link href="creditStyle.css" rel="stylesheet">
<meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
<link rel="shortout icon" type="image/x-icon" href="images/debit.png">
</head>
<body>
<div class="testbox4">
<div class="testbox5">
  <h1>Debit Amount</h1></div>
  <form action="debitAmountServlet" method="post">
  <hr>
  <br>
  <center><h3>Account Number</h3>
  <input type="text" name="acc_no" id="name" placeholder="account number" required/>
  <br>
  <br><p><h3>Debit Amount</h3></p>
  <input type="text" name="debit_amount" id="name" placeholder="amount in INR" required/>
  <br>
   <input type="submit" class="button" value="Debit"><center>
  </form>
</div>
<div class="testbox6">
<img src="images/debitCard.gif" width="343px" height="370px">
</div>
</body>
</html>