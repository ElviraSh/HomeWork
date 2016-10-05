<%--
  Created by IntelliJ IDEA.
  User: Elvira
  Date: 04.10.2016
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<center>
    <h2>Welcome!</h2>
    <br><form method='POST'>
        <table>
             <tr><td>User:</td><td>
                <input type=text name='user' size=30>
                </td></tr><tr><td>Password:</td>
                <td>
                    <input type=password name='pass' size=30></td></tr>
            </table><br>
        <input type=checkbox checked="remember">Remember</input>
        <p><input type=submit value="Login">
            </p>

            </form>
    </center>+
</body>
</html>
