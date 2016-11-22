<%--
  Created by IntelliJ IDEA.
  User: Elvira
  Date: 12.11.2016
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

<%@ page import="java.sql.*" %>

<%
    String comment = request.getParameter("comment");
    String email = request.getParameter("email");
    long product = Long.parseLong(request.getParameter("product"));
    if (comment == null || email == null || comment.trim().equals("") || email.trim().equals("")) {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        out.print("<p>Пожалуйста, напишите комментарий</p>");
    } else {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "knigafanfikov2w8i123987");
            PreparedStatement ps = con.prepareStatement("insert into comments(comment,email,product) values(?,?,?)");
            ps.setString(1, comment);
            ps.setString(2, email);
            ps.setLong(3, product);
            int i = ps.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement("select * from comments where product=" + product + " order by comm_id desc");
            ResultSet rs = ps2.executeQuery();


            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            out.print("<meta charset='UTF-8'><center> COMMENTS:</center><br><br>");

            while (rs.next()) {
                request.setCharacterEncoding("utf-8");
                response.setCharacterEncoding("utf-8");

                out.print("<div class='box'>");

                out.print(rs.getString(1) );

                out.print("</div>");
                out.print("</form>");
                out.print("<br>");


            }
            con.close();
        } catch (Exception e) {

            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            out.print("<meta charset='UTF-8'>");
            out.print(e);
        }
    }

%>
</body>
</html>
