<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String form_date=request.getParameter("form_date");
String to_date=request.getParameter("to_date");
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
<!DOCTYPE html>
<html>
<title>Grid view</title>
<link href="searchDateStyling.css" rel="stylesheet">
<link rel="shortout icon" type="image/x-icon" href="images/result.png">
<body>
<div class="table-wrapper">
<center><h1>Customer Transaction History</h1>
<table class="fl-table">
<thead>
<tr>
<th>Reference Number</th>
<th>Account Number</th>
<th>Date & Time</th>
<th>Description</th>
<th>Withdrawals</th>
<th>Credit</th>
<th>Running Balance</th>
</tr>
</thead>
<tbody>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select distinct * from customer where Date_Time between '"+form_date+"' and '"+to_date+"'";
resultSet = statement.executeQuery(sql);
while(resultSet.next())
{
%>
<tr>
<td><%=resultSet.getString("Ref_Number") %></td>
<td><b><%=resultSet.getString("Account_Number") %></b></td>
<td><%=resultSet.getString("Date_Time") %></td>
<td><%=resultSet.getString("Description") %></td>
<td><%=resultSet.getString("Withdrawals") %></td>
<td><%=resultSet.getString("Credit") %></td>
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
<center><button class="glow-on-hover" type="button">Download as Excel</button>
<span class="tab"></span>
<button class="glow-on-hover1" type="button">Download as PDF</button>
<span class="tab"></span>
<button class="glow-on-hover2" type="button">Download as Word</button></center>
</body>
</html>