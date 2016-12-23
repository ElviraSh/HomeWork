<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 01.11.2016
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%
    String product_name = request.getParameter("product_name");
    session.setAttribute("product_name", product_name);
    String description = request.getParameter("description");
/*
    String author = request.getParameter("author");
*/
    int price = Integer.parseInt(request.getParameter("price"));
    long product_id = Long.parseLong(request.getParameter("product_id"));
    Class.forName("org.postgresql.Driver");
    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
            "postgres", "knigafanfikov2w8i123987");
    Statement st = con.createStatement();
    int k = st.executeUpdate("DELETE FROM WHERE product_id =?");
    out.println("Успешно");
%>
</body>
</html>

