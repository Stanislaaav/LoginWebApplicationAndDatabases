<%--
  Created by IntelliJ IDEA.
  User: Puncky
  Date: 28.6.2018 г.
  Time: 15:19 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Home Page</h3>

This is demo Simple web application using jsp, servlet & amp; Jdbc<br><br>
<b>It includes the following functions:</b>
<ul>
    <li>Login</li>
    <li>Storing user information in cookie</li>
    <li>Product List</li>
    <li>Create Product list</li>
    <li>Edit Product</li>
    <li>Delete Product</li>
</ul>

<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
