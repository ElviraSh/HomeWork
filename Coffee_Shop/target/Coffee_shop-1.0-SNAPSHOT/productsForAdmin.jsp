<%@ page import="ru.kpfu.itis.ShalafaevaElvira.objects.Coffee" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05.11.2016
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <title>CoffeeShop_Администратор</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<div id="wrapper">
    <div class="panel-top">
        <div class="center clearfix">
            <div class="login">
                <a href="productsForAdmin.jsp?page=1">${email}</a>
                <span>/</span>
                <a href="/logout">Выход</a>
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
   <%-- <div id="header" class="center clearfix">
    </div>--%>
    <div id="home">
        <div class="home-bg">
            <div class="center">
                <a href="productsForAdmin.jsp?page=1" class="link-home"></a>
                <h2 class="title-home"> <img src="img/hb-logo.png" width="50px" height="50px">Coffee shop</h2>
            </div>
        </div>
    </div>

    <form action="addProduct.html">
        <input type="submit" class="submit-class-add" value="ДОБАВИТЬ"/><br/><br/>
    </form>
    <div class="middle clearfix center">
        <div class="sidebar"></div>
        <jsp:useBean id="coffeeList" class="ru.kpfu.itis.ShalafaevaElvira.repositories.CoffeeList" scope="page"/>
        <h3>${param.name}</h3>
        <%
            for (Coffee coffee : coffeeList.getRecords(pageid, total)) {
        %>
        <div class="products">
            <form action="/edit.jsp" method="post">
                <div class="p-img">
                    <input type="hidden" name="product_id" value="<%=coffee.getId()%>">
                    <center><input type="hidden" name="image" value="<%=coffee.getImage()%>"><img
                            src="<%=coffee.getImage()%>" height="240" width="230" alt="Обложка"/></center>
                </div>

                <div class="p-footer">
                    <h6><input type="hidden" name="name"
                               value="<%=coffee.getName()%>"><%=coffee.getName()%>< </h6>
                    <input type="hidden" name="description" value="<%=coffee.getDescription()%>">
                    <p><%=coffee.getDescription().substring(0, 50)%>...</p>
                    <div class="p-footer-product clearfix">
                        <span class="price"><input type="hidden" name="price"
                                                   value="<%=coffee.getPrice()%>"><%=coffee.getPrice()%> руб.</span>
                        <input type="submit" class="right add-cart" value="РЕДАКТИРОВАТЬ"/>
                    </div>
                </div>
            </form>
            <form action="/delete" method="get">
                <input type="hidden" name="product_id" value="<%=coffee.getId()%>">

                <input type="hidden" name="image" value="<%=coffee.getImage()%>">
                <div class="p-footer">
                    <input type="hidden" name="name" value="<%=coffee.getName()%>">

                    <input type="hidden" name="description" value="<%=coffee.getDescription()%>">
                    <div class="p-footer-product clearfix">
                        <input type="hidden" name="price" value="<%=coffee.getPrice()%>">
                        <input type="submit" class="right add-cart" value="УДАЛИТЬ" onclick="return confirm('Вы действительно хотите удалить этот кофе?')"/>
                    </div>
                </div>
            </form>
        </div>
        <%}%>
    </div>
</div>
<center>
<a href="productsForAdmin.jsp?page=1">1</a>
<a href="productsForAdmin.jsp?page=2">2</a>

<a href="productsForAdmin.jsp?page=3">3</a>

</center>
</div>
<div id="footer">
    <a href="#home-link" class="home-link">&nbsp;</a>
    <div class="center clearfix">
        <div class="f-about">
            <h5 class="f-title">Контакты<br></h5>
            <p>Наш контактный телефон"<br>
                8(900)900-90-00</p>
        </div>
    </div>
</div>
