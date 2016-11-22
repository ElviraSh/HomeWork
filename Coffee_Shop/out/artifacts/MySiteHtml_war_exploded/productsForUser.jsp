<%@ page import="ru.kpfu.itis.ShalafaevaElvira.objects.Coffee" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 06.11.2016
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>CoffeeShop</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<div id="wrapper">
    <div class="panel-top">
        <div class="center clearfix">
            <div class="basket">
               <img src="img/cart.png" width="40px" height="30px" onclick="return confirm('Выберите какой-либо продукт прежде, чем перейти в Корзину')">
            </div>
            <div class="login">
                <a href="productsForUser.jsp?page=1">${email}</a>
                <span>/</span>
                <a href="/logout">Выход</a>

            </div>
        </div>
    </div>

    <div id="home">
        <div class="home-bg">
            <div class="center">
                <a href="productsForUser.jsp?page=1" class="link-home"></a>
                <h2 class="title-home"> <img src="img/hb-logo.png" width="50px" height="50px">Coffee shop</h2>
            </div>
        </div>
    </div>
    <% int spageid = Integer.parseInt(request.getParameter("page"));
        int pageid = spageid;
        int total = 10;
        if (pageid == 1) {
        } else {
            pageid = pageid - 1;
            pageid = pageid * total + 1;
        }
    %>

    <div class="middle clearfix center">
        <div class="sidebar"></div>
        <jsp:useBean id="coffeeList" class="ru.kpfu.itis.ShalafaevaElvira.repositories.CoffeeList" scope="page"/>
        <h3>${param.name}</h3>
        <%
            for (Coffee coffee : coffeeList.getRecords(pageid, total)) {
        %>
        <div class="products2">
            <form action="/addtocart">
                <div class="p-img">
                    <center><input type="hidden" name="image" value="<%=coffee.getImage()%>"><img
                            src="<%=coffee.getImage()%>" height="220" width="210" style="margin-top: 30px" alt="Обложка"/></center>
                </div>
                <div class="p-footer">
                    <h6><input type="hidden" name="name"
                               value="<%=coffee.getName()%>"><%=coffee.getName()%><p>
                    </h6
                    <input type="hidden" name="description" value="<%=coffee.getDescription()%>">
                    <p><%=coffee.getDescription().substring(0, 50)%>...</p>
                    <input type="hidden" name="product_id" value="<%=coffee.getId()%>">
                    <div class="p-footer-product clearfix">
                        <span class="price"><input type="hidden" name="price"
                                                   value="<%=coffee.getPrice()%>"><%=coffee.getPrice()%> руб.</span>
                        <input type="submit" class="right add-cart" value="ДОБАВИТЬ В КОРЗИНУ"/>
                    </div>
                </div>
            </form>
            <form action="description.jsp?product=<%=coffee.getId()%>">
                <input type="hidden" name="image" value="<%=coffee.getImage()%>">
                <div class="p-footer">
                    <input type="hidden" name="name" value="<%=coffee.getName()%>">

                    <input type="hidden" name="description" value="<%=coffee.getDescription()%>">
                    <input type="hidden" name="product_id" value="<%=coffee.getId()%>">
                    <div class="p-footer-product clearfix">
                        <input type="hidden" name="price" value="<%=coffee.getPrice()%>">
                        <input type="submit" class="right add-cart" value="ОПИСАНИЕ"/>
                    </div>
                </div>
            </form>
        </div>
        <%}%>
    </div>
</div>
<center>
<a href="productsForUser.jsp?page=1">1</a>
<a href="productsForUser.jsp?page=2">2</a>

<a href="productsForUser.jsp?page=3">3</a>
</center>
</div>
<div id="footer">
    <a href="#home-link" class="home-link">&nbsp;</a>
    <div class="center clearfix">
        <div class="f-about">
            <h5 class="f-title">Контакты</h5>
            <p>Наш контактный телефон<br>
                8(900)900-90-00</p>
        </div>
    </div>
</div>