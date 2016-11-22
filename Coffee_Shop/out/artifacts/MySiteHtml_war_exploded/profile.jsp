
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 06.11.2016
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<center>
    <h2> Hi, ${email}!</h2>
    <form method='get' action='/logout'>
        <br>
        <input type='submit' value='Logout'>
    </form>
</center>
</body>
</html>
