<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23.10.2016
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ page import="java.sql.*" %>
]<jsp:useBean class="servlets.Lin" id="log">
    <%
        String url = "jdbc:mysql://localhost:3306/mydb";
        String login = "";
        String password = "qwerty";
        Statement stmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM CUSTOMER";
        Connection con = DriverManager.getConnection(url, login, password);
        try {
            con = DriverManager.getConnection(url,"qwerty", "qwerty");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                log.getEmail();
                log.getPassword();
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
            }
            try {
                stmt.close();
            } catch (SQLException se) {
            }
            try {
                rs.close();
            } catch (SQLException se) {
            }
        }
    %>
</jsp:useBean>--%>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<div id="wrapper">
    <div class="panel-top">
        <div class="center clearfix">
        </div>
    </div>
    <div id="header" class="center clearfix">
    </div>
    <div id="home">
        <div class="home-bg">
            <div class="center">
                <a href="products.html" class="link-home"></a>
                <h2 class="title-home">КНИГИ.РУ</h2>
            </div>
        </div>
    </div>
    <div class="middle clearfix center">
        <div class="sidebar"></div>
        <div class="content">
            <div class="registr">
                <form action="" method="post">
                    <div class="header-login"><br><br><h4>ВХОД</h4></div>
                    <div class="main">
                        <br>
                        <br>
                        <br>
                        <p>АДРЕС ЭЛЕКТРОННОЙ ПОЧТЫ:</p>
                        <br>
                        <input type="text" name="user" class="input-class" placeholder='Email'>
                        <br>
                        <br>
                        <p>ПАРОЛЬ:</p>
                        <br>
                        <input type="password" name="pass" class="input-class " placeholder='Пароль'>
                        <br>
                        <br>
                        <div class="checkbox-class">
                            <input type="checkbox"> ЗАПОМНИТЬ МЕНЯ</input>
                        </div>
                        <br>
                        <br>
                        <br>
                    </div>
                    <input type="submit" class="submit-class-login" value="ВОЙТИ">
                </form>
            </div>
        </div>
    </div>

</div>
<div id="footer">
    <a href="#home-link" class="home-link">&nbsp;</a>
    <div class="center clearfix">
        <div class="f-about">
            <h5 class="f-title">Контакты</h5>
            <p>Книжный интернет-магазин "Книги.ру"
                Электронная почта: shop@knigi.ru</p>
        </div>
    </div>
</div>
</body>
</html>