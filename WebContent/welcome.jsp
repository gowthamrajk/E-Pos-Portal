<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>page</title>
</head>
<body>
    <h3>Login successful!!!</h3>
    <h4>${acc_name}</h4>
    <%String someName = (String)request.getAttribute("attributeName");
    out.print("your name"+someName);%>
</body>
</html>