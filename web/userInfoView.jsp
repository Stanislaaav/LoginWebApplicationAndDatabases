<%--
  Created by IntelliJ IDEA.
  User: Puncky
  Date: 28.6.2018 г.
  Time: 17:39 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Info</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Hello:${user.userName}</h3>

User Name: <b>${user.userName}</b>
<b/>
Gender: ${user.gender}<br/>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>
