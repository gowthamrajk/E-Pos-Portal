<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String name=request.getParameter("name");
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
<body>
<h1>Show Transaction</h1>
<table border="1">
<tr>
<td>Name</td>
<td>progress</td>
<td>enrolled</td>
</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from student1 where enrolled between '"+form_date+"' and '"+to_date+"'";
resultSet = statement.executeQuery(sql);
while(resultSet.next())
{
%>
<tr>
<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("enrolled") %></td>
<td><%=resultSet.getString("progress") %></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>