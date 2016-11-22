<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30.10.2016
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title></title>
</head>
<body>

<% request.setCharacterEncoding("utf-8"); %>
<% response.setCharacterEncoding("utf-8"); %>

<%@ page import="java.sql.*" %>
<%
    String email = request.getParameter("email");
    session.setAttribute("email", email);
    String password = request.getParameter("password");
    String username = request.getParameter("username");
    Class.forName("org.postgresql.Driver");
    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
            "postgres", "knigafanfikov2w8i123987");
    Statement st = con.createStatement();
    int k = st.executeUpdate("insert into users(email, password, username) values ('" + email + "','" + password + "','" + username + "')");
 /*   out.println("Registered");
    response.sendRedirect("/login");
*/
%>
<a href="login">Login</a><br/><br/>
<a href="index.html">Home</a>
</body>
</html>
