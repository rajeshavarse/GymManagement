<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Update Participant</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<div class="container">
<%@include file="header.jsp" %>
<h4>Update Member details</h4>
<form action="participant?action=update" method="post">
    <input type="hidden" name="id" value="${participant.id}">
    <label>Name:</label><br>
    <input type="text" name="name" value="${participant.name}"><br>
    <label>Age:</label><br>
    <input type="number" name="age" value="${participant.age}"><br>
    <label>Email:</label><br>
    <input type="email" name="email" value="${participant.email}"><br>
    <label>Batch ID:</label><br>
    <input type="number" name="batchId" value="${participant.batchId}"><br><br>
    <input type="submit" value="Update">
      <a type="button" class="btn" href ="participant?action=list">Cancel</a>
</form>
<%@include file="footer.jsp" %>
</div>
</body>
</html>