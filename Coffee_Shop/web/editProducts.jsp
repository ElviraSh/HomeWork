<%--
  Created by IntelliJ IDEA.
  User: Elvira
  Date: 12.11.2016
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CoffeeShop_Редактирование</title>
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

    int product_id = Integer.parseInt(request.getParameter("product_id"));




    if(product_id !=0/* && product_name!=null && description!=null && image!=null && price!=null*/){

        try {

         Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
            "postgres", "knigafanfikov2w8i123987");
            /*Statement st = con.createStatement();*/

            PreparedStatement st = con.prepareStatement("UPDATE products SET product_name=?,price=? ,image=?, description=?   WHERE product_id=? ;");
            st.setString(1, product_name);
            st.setString(4, description);
            st.setString(3, image);
            st.setInt(2, price);
            st.setInt(5, product_id);
            st.execute();

            response.sendRedirect("/productsForAdmin.jsp?page=1");

            return;


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    else {
        response.sendRedirect("/edit.jsp");

    }

%>
</body>
</html>
