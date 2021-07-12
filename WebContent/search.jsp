<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Search File</title>
<link href="searchStyling.css" rel="stylesheet">
<link rel="shortout icon" type="image/x-icon" href="images/searchIcon.png">
</head>
<body>
<div class="frame">
<div class="frame2"><center><div class="txt"> Search Your Requirements</div></center></div>
<br><br><br><form action="SearchServlet" method="post" class="search-bar">
	<input type="search" name="search"  pattern=".*\S.*" required>
	<button class="search-btn" type="submit">
		<span>Search</span>
	</button>
</form>
<div class="frame3">
<div class="txt1">Search based on your registered account number</div>
<div class="txt2"># user proper account number to search #</div>
</div>
<div class="frame4">
<a class="register-button" href="searchDate.jsp">click here - Search by Date</a>
</div>
<img src="images/search-icon.gif" width="300px" height="300px">
</div>
</body>
</html>
