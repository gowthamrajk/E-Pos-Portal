<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Successful</title>
<meta http-equiv='refresh' content='6;URL=addAccount.jsp'>;
<link href="registerSuccessStyling.css" rel="stylesheet" type="text/css"/>
<link rel="shortout icon" type="image/x-icon" href="images/error-icon.png">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
</head>
<body>
<center>
  <div class="row col-md-10 col-md-offset-3">
   <div class="card card-body">
   <center><img src="images/error.gif" width="200px" height="200px"></center>
    <br><h1>Hello ${attributeName}, this account do not exits with us !!!</h1>
    <h3>Try creating a new account and start your transaction</h3>
   </div>
  </div>
 </center>
</body>
</html>