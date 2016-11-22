<%--
&lt;%&ndash;
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30.10.2016
  Time: 19:43
  To change this template use File | Settings | File Templates.
&ndash;%&gt;
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление продукта</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    String product_name = request.getParameter("product_name");
    session.setAttribute("product_name", product_name);
    String description = request.getParameter("description");

    int price = Integer.parseInt(request.getParameter("price"));
    String image = request.getParameter("image");
    Class.forName("org.postgresql.Driver");
    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
            "postgres", "knigafanfikov2w8i123987");
    Statement st = con.createStatement();
    int k = st.executeUpdate("insert into products(product_name, price,  image,  description) values ('" + product_name + "','" + price + "','" + image + "','" + description + "')");
    response.sendRedirect("productsForAdmin.jsp");
%>
</body>
</html>
--%>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30.10.2016
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление продукта</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    String product_name = request.getParameter("product_name");
    session.setAttribute("product_name", product_name);
    String description = request.getParameter("description");

    int price = Integer.parseInt(request.getParameter("price"));
    String image = request.getParameter("image");
    try {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres", "knigafanfikov2w8i123987");
        Statement st = con.createStatement();
/*
        int k = st.executeUpdate("insert into products(product_name, price, image, description) values ('" + product_name + "','" + price + "','" + image + "','" + description + "')");
*/
    /*int k = */
        st.executeUpdate("insert into products(product_name, price,  image,  description) values ('" + product_name + "','" + price + "','" + image + "','" + description + "')");
    }catch (Exception e) {
    out.print(e);}
    finally {

        response.sendRedirect("productsForAdmin.jsp?page=1");
    }
%>
</body>
</html>
