<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Account</title>
<link href="creditStyle.css" rel="stylesheet">
<meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
<link rel="shortout icon" type="image/x-icon" href="images/add-account.png">
</head>
<body>
<div class="testbox7">
<div class="testbox8">
  <h1>Add New Account</h1></div>
  <form action="addNewAccount" method="post">
  <hr>
  <br>
  <center><h3>Account Number</h3>
  <input type="text" name="acc_no" id="name" placeholder="account number" required/>
  <br>
  <p><h3>Initial Amount</h3></p>
  <input type="text" name="Init_amt" id="name" placeholder="amount in INR" required/>
  <br>
   <input type="submit" class="button" value="Add"><center>
  </form>
</div>
</body>
</html>