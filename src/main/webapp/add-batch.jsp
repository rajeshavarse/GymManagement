<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Add New Batch</title>
 <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<div class="container">
<%@include file="header.jsp" %>
<h4>Add New Batch</h4>
<form action="batch?action=insert" method="post">
    <label>Name:</label><br>
    <input type="text" name="batchName" required><br>
    <label>Batch Time:</label><br>
    <input type="time" name="batchTime" required><br>
  	
    <label>Max Participants:</label><br>
    <input type="number" min=1 name="maxParticipants"><br><br>
    <input type="submit" value="Submit">
   
        <a type="button" class="btn" href ="batch?action=list">Cancel</a>
</form>
<%@include file="footer.jsp" %>
</div>
</body>
</html>