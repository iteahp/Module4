<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 1/10/2022
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<form action="/create" method="post">
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Img</th>
        </tr>
        <tr>
            <td><input type="number" name="id"></td>
            <td><input type="text" name="name"></td>
            <td><input type="text" name="img"></td>

        </tr>
    </table>
    <button type="submit" class="btn btn-success">Create</button>

</form>
</body>
</html>
