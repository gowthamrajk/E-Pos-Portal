<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>uplaod File</title>
<link rel="shortout icon" type="image/x-icon" href="images/upload-icon.png">
<link href="uploadStyling.css" rel="stylesheet">
</head>
<body>
<div class="frame">
	<div class="center">
		<div class="title">
			<h1>Drop your file here</h1>
		</div>
		<div class="dropzone">
			<img src="http://100dayscss.com/codepen/upload.svg" class="upload-icon" />
			<form action="upload" method="post" enctype="multipart/form-data">
			<input type="file" name="file" class="upload-input" id="file" multiple onchange="javascript:updateList()" />
			<div id="fileList"></div>
		</div>
		<input type="submit" class="btn" value="upload File" name="uploadbutton"/>
		<br>
	</div>
	<div class="center1">
	<img src="images/notification.png"/>
	<h1>Kindly upload only (.csv, .xlsx)</h1>
	<h1>File name should be (Student.xlsx)</h1>
	<div>
</div>
</body>

<script src="upload.js"></script>
</html>



