<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Batch List</title>
 <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<div class="container">
<%@include file="header.jsp" %>
<h4>Batches</h4>
<a href="batch?action=new">Add New Batch</a> | 
<a type="button" href ="index.jsp">Home</a>
<table border="1" >
    <tr>
       <!--  <th>ID</th> -->
        <th>Batch Name</th>
        <th>Batch Time</th>
        <th>Max Participant</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="batch" items="${batches}">
        <tr>
            <!-- <td>${batch.id}</td> -->
            <td>${batch.batchName}</td>
           <td>${batch.batchTime}</td>
           <td>${batch.maxParticipants}</td>
            <td>
                <a href="batch?action=edit&id=${batch.id}">Edit</a> |
                <a href="batch?action=delete&id=${batch.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="footer.jsp" %>
</div>
</body>
</html>