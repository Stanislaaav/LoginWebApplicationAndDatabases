<%--
  Created by IntelliJ IDEA.
  User: Puncky
  Date: 30.6.2018 г.
  Time: 11:06 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Delete Product</h3>
<p style="color: red;">${errorString}</p>
<a href="productList">Product List</a>

<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
