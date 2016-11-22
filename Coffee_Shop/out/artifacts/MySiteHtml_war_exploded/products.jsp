<%@ page import="classes.Book" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23.10.2016
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Products</title>
    <link rel="stylesheet" href="css/style.css"/>

</head>
<div id="wrapper">
    <div class="panel-top">
        <div class="center clearfix">
            <div class="basket">
                <a href="cart.jsp"><span>Корзина</span></a>
            </div>
            <div class="login">
                <%--  <a href="<%= response.sendRedirect("/login") %>">
                      Вход</a>&nbsp;--%>
                <a href="login.jsp">Вход</a>
                <span>/</span>
                <a href="registration.html">Регистрация</a>
            </div>
        </div>
    </div>
    <div id="header" class="center clearfix">
    </div>
    <div id="home">
        <div class="home-bg">
            <div class="center">
                <a href="#" class="link-home"></a>
                <h2 class="title-home">КНИГИ.РУ</h2>

            </div>
        </div>
    </div>
    <div class="middle clearfix center">
        <div class="sidebar"></div>
        <div class="content">

            <jsp:useBean id="bookList" class="classes.BookList" scope="page"/>
            <%
                for (Book book : bookList.getBookList()) {
            %>
            <div class="product-catalog clearfix">
                <div class="products">

                    <div class="p-img">
                        <br>
                        <a href="#">
                            <center><img src="img/product1.jpg" height="247" width="191" alt=""/></center>
                        </a>
                    </div>
                    <div class="p-footer">
                        <h6><%=book.getName()%><p><span><%=book.getAuthor() %></span></h6>
                        <a href="description.jsp"><p><%=book.getDescription()%></p></a>
                        <div class="p-footer-price clearfix">
                            <span class="price"><%=book.getPrice() %> руб.</span>
                            <a href="#" class="right add-cart">ДОБАВИТЬ В КОРЗИНУ</a>
                        </div>
                    </div>
                </div>
            </div>
            <%}%>
            <div class="pagination">
                <ul class="clearfix">
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">6</a></li>
                    <li><a href="#">&raquo;</a></li>
                </ul>
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