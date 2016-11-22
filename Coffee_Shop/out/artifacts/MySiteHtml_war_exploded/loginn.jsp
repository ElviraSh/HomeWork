<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30.10.2016
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title></title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%
    String email = request.getParameter("email");
    session.setAttribute("email", email);
    String password = request.getParameter("password");
    Class.forName("org.postgresql.Driver");
    java.sql.Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "ptvabhf1604");
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("select * from users where email='" + email + "'");
    if (rs.next()) {
        if (rs.getString(2).equals(password)) {
response.sendRedirect("books.jsp");
        } else {
            out.println("Invalid password try again");
        }
    } else {
        out.println("Ooooops");
    }
%>
<a href="index.html">Home</a>
</body>
</html>