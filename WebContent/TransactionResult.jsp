<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String acc_no = (String)request.getAttribute("attributeName");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "demo";
String userid = "root";
String password = "Killer@1207";
try
{
Class.forName(driver);
} 
catch (ClassNotFoundException e) 
{
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<title>Grid view</title>
<link href="searchDateStyling.css" rel="stylesheet">
<link rel="shortout icon" type="image/x-icon" href="images/result.png">
<body>
<div class="table-wrapper">
<center><h1>Transaction History</h1>
<table class="fl-table">
<thead>
<tr>
<th>Account Number</th>
<th>Date & Time</th>
<th>Credit</th>
<th>Debit</th>
<th>Running Balance</th>
</tr>
</thead>
<tbody>
<%
try
{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select distinct * from transaction where Account_Number='" + acc_no + "'";
resultSet = statement.executeQuery(sql);
while(resultSet.next())
{
%>
<tr>
<td><%=resultSet.getString("Account_Number") %></td>
<td><%=resultSet.getString("Date_Time") %></td>
<td><%=resultSet.getString("Credit") %></td>
<td><%=resultSet.getString("Debit") %></td>
<td><%=resultSet.getString("runningBalance") %></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</tbody>
</table></center>
</div>
</body>
</html>