<%--
  Created by IntelliJ IDEA.
  User: Puncky
  Date: 28.6.2018 г.
  Time: 14:36 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
</head>
<body>
<div style="background: #E0E0E0; height:55px; padding:5px;">
    <div style="float: left">
        <h1>My site</h1>
    </div>

    <div style="float: right; padding: 10px; text-align: right;">
        <!--User store in session with attribute: loginedUser-->
        Hello <b>${loginedUser.userName}</b>
        <br/>
        Search<input name="search">
    </div>
</div>
</body>
</html>
