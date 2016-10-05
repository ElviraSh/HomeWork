<%--
  Created by IntelliJ IDEA.
  User: Elvira
  Date: 04.10.2016
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<center>

    <h1> Hi,</h1>
        <c: set var ="user" value="req.getSession().getAttribute('user')"/>
        <h1>${user}</h1>

        <br><form method="get" action="logout">
        <input type="submit" value="Logout">
        </form>
</center>

</body>
</html>
