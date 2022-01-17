<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 1/10/2022
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<button type="button" class="btn btn-success"><a href="/create">Create</a></button>
<table border="1px solid">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Img</th>
    </tr>
    <c:forEach items="${products}" var="p">
    <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td><img src="${p.img}" alt="Img-Product" width="150" height="200"></td>
            <td><button type="button" class="btn btn-danger"><a href="/delete?&&id=${p.id}">Delete</a></button></td>
            <td><button type="button" class="btn btn-warning"><a href="/update?&&id=${p.id}">Edit</a></button></td>
    </tr>
    </c:forEach>
</table>

</body>
</html>
