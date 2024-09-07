<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Add New Participant</title>
 <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="container">
<header><h3>GYM Management System</h3></header>
<h4>Add New Member</h4>
<form action="participant?action=insert" method="post">
    <label>Name:</label><br>
    <input type="text" name="name" required><br>
    <label>Age:</label><br>
    <input type="number" name="age" ><br>
    <label>Email:</label><br>
    <input type="email" name="email"><br>
    <label>Batch ID:</label><br>
    <input type="number" name="batchId"><br><br>
    <input type="submit" value="Submit">
    <a type="button" class="btn" href ="participant?action=list">Cancel</a>
</form>
<%@include file="footer.jsp" %>
</div>
</body>
</html>