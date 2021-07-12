<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String name=request.getParameter("name");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "demo";
String userid = "root";
String password = "Killer@1207";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Transaction</title>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script>
$( function() {
$( "#datepicker" ).datepicker({ changeMonth: true, changeYear: true });
$( "#datepicker" ).datepicker( "option", "dateFormat", "yy-mm-dd" );
} );
</script>
<script>
$( function() {
$( "#datepicker1" ).datepicker({ changeMonth: true, changeYear: true });
$( "#datepicker1" ).datepicker( "option", "dateFormat", "yy-mm-dd" );
} );
</script>
</head>
<body>
<form method="post" action="show-transaction.jsp">
<p> From Date: <input type="text" name="form_date" id="datepicker"></p>
<p> To Date: <input type="text" name="to_date" id="datepicker1"></p>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from student1" ;
resultSet = statement.executeQuery(sql);
%>
Name : <select name="name">
<option value="" disabled selected>Choose name</option>
<%
while(resultSet.next()) {
%>
<option value=<%=resultSet.getString("name")%>> <%=resultSet.getString("name")%></option>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</select>
<br>
<br>
<input type="submit" value="Submit"><br>
</form>
</body>
</html>