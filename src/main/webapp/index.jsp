<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GYM Management System</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="container">
<%@include file="header.jsp" %>
<h4>Welcome to GYM Management System</h4>
<a type="button" href ="participant?action=list">Manage Members</a> |
<a type="button" href ="batch?action=list">Manage Batches</a>
<%@include file="footer.jsp" %>
</div>

</body>
</html>