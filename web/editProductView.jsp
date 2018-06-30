<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Puncky
  Date: 29.6.2018 г.
  Time: 18:29 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Edint Product</h3>

<c:if test="${not empty product}">
    <form method="post" action="${pageContext.request.contextPath}/editProduct">
        <input type = "hiden" name="code" value="${product.code}"/>
        <table border="0">
            <tr>
                <td>Code</td>
                <td style="color: red;">${product.code}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="${product.name}"/></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name="price" value="${product.price}" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit"/>
                    <a href="${pageContext.request.contextPath}/productList">Cancel</a>
                </td>
            </tr>
        </table>
    </form>
</c:if>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
