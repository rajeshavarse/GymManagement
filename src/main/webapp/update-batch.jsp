<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Update Batch</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<div class="container">
<%@include file="header.jsp" %>
<h4>Update Batch details</h4>
<form action="batch?action=update" method="post">
    <input type="hidden" name="id" value="${batch.id}">
    <label>Name:</label><br>
    <input type="text" name="batchName" value="${batch.batchName}"><br>
    <label>Batch Time:</label><br>
    <input type="time" name="batchTime" value="${batch.batchTime}"><br>
  	
    <label>Max Participants:</label><br>
    <input type="number" name="maxParticipants" value="${batch.maxParticipants}" }><br><br>
    <input type="submit" value="Update">
     <a type="button" class="btn" href ="batch?action=list">Cancel</a>
</form>
<%@include file="footer.jsp" %>
</div>
</body>
</html>