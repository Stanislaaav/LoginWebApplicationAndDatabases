<%--
  Created by IntelliJ IDEA.
  User: Puncky
  Date: 28.6.2018 г.
  Time: 14:47 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<div style="padding: 5px;">

    <a href="${pageContext.request.contextPath}/homeView.jsp">Home</a>
    |
    <a href="${pageContext.request.contextPath}/productList">Product List</a>
    |
    <a href="${pageContext.request.contextPath}/userInfo">My Account Info</a>
    |
    <a href="${pageContext.request.contextPath}/login">Login</a>

</div>
</body>
</html>
