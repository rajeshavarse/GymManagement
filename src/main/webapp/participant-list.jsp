<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Participants List</title>
 <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<div class="container">
<%@include file="header.jsp" %>
<h4>Enrolled Members</h4>

<a href="participant?action=new">Add New Member</a>
<a type="button" href ="index.jsp">Home</a>
<table border="1" >
    <tr>
        <th>Member ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Email</th>
        <th>Batch ID</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="participant" items="${participants}">
        <tr>
            <td>${participant.id}</td>
            <td>${participant.name}</td>
            <td>${participant.age}</td>
            <td>${participant.email}</td>
            <td>${participant.batchId}</td>
            <td>
                <a href="participant?action=edit&id=${participant.id}">Edit</a> |
                <a href="participant?action=delete&id=${participant.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="footer.jsp" %>
</div>
</body>
</html>