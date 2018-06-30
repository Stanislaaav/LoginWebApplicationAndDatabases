<%--
  Created by IntelliJ IDEA.
  User: Puncky
  Date: 29.6.2018 г.
  Time: 17:00 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Create Product</h3>

<p style="color: red;">${errorString}</p>

<form action="${pageContext.request.contextPath}/createProduct" method="post">
    <table border="0">
        <tr>
            <td>Code</td>
            <td><input type="text" name="code" style="${product.code}"></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="${product.name}"></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price" value="${product.price}"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit">
                <a href="productList">Cancel</a>
            </td>
        </tr>
    </table>
</form>

<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
