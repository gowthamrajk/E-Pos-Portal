<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv='refresh' content='4;URL=upload.jsp'>;
<link rel="shortout icon" type="image/x-icon" href="images/error-icon.png">
<title>Upload failed</title>
</head>
<body>
<center><img src="images/error.gif" width="300px" height="300px"></center>
<center><h1>
<% String msg = (String)request.getAttribute("message");
   out.println(msg);
%>
</center></h1>
</body>
</html>