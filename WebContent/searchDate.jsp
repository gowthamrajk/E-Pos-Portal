<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Transaction</title>
<link href="searchDateStyling2.css" rel="stylesheet">
<link rel="shortout icon" type="image/x-icon" href="images/searchIcon.png">
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
<div class="frame">
<div class="frame2"><center><div class="txt"> Search Your Date</div></center></div>
<form method="post" action="searchDateResult.jsp">
<div class="picker1"> <p> From Date:<p><span class="tab1"></span><input type="text" name="form_date" id="datepicker"></div></p></p>
<div class="picker2"> <p> To Date:<p><span class="tab2"></span> <input type="text" name="to_date" id="datepicker1"></div></p></p>
<br>
<center><input class="btn" type="submit" value="Search"></button></center><br>
</form>
</div>
<div class="frame3"><br><br><center><img src="images/calender.gif" width="290px" height="290px"></center>
</div>
</body>
</html>