<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 06.11.2016
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Комментарий</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%@ page import="static classes.Products.getConnection" %>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");%>
<%
    String comment = request.getParameter("comment");
    String email = request.getParameter("email");

    Connection con = getConnection();
    PreparedStatement ps = con.prepareStatement("insert into comments(comment) values " + comment);
    int rs = ps.executeUpdate();
    if (rs != 0)
        response.sendRedirect("/description.jsp");%>
</body>
</html>
