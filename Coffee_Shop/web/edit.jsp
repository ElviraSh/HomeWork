<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05.11.2016
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>CoffeeShop_Редактирование</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<div id="wrapper">
    <div class="panel-top">
        <div class="center clearfix">
            <div class="basket">
                <img src="img/cart.png" width="40px" height="30px" onclick="return confirm('Выберите какой-либо продукт прежде, чем перейти в Корзину')">
            </div>
        </div>
    </div>
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
    <div class="middle clearfix center">
        <div class="sidebar"></div>

        <div class="content">
            <div class="registr">
                <form class="simple_form" action="/editProducts.jsp" method="get">
                    <div ID="wrapper2">
                        <% request.setCharacterEncoding("utf-8"); %>
                        <% response.setCharacterEncoding("utf-8"); %><%--
                             <input type="text" class="input-class" name="product_id"
                                    value="<%=request.getParameter("product_id")%>"/>--%>

                        <input type="hidden" name="product_id" value="<%=request.getParameter("product_id")%>">
                        <br/><br/>
                        <p style="margin-left: 15px">НАЗВАНИЕ:</p> <br/><input type="text" class="input-class2" name="product_name"
                                        value="<%=request.getParameter("name")%>"/><br/><br/>
                        <p style="margin-left: 15px">ЦЕНА:</p> <br/><input type="text" class="input-class2" name="price"
                                               value="<%=request.getParameter("price") %>"/><br/><br/>

                        <p style="margin-left: 15px">ИЗОБРАЖЕНИЕ:</p> <br/><input type="text" class="input-class2" name="image"
                                                      value="<%=request.getParameter("image")%>"/><br/><br/><br/>
                        <p style="margin-left: 15px">ОПИСАНИЕ:</p> <br/><input type="text" class="input-class2" name="description"
                                        value="<%=request.getParameter("description") %>"/><br/><br/>


                       <input type='submit' class='button' value='РЕДАКТИРОВАТЬ'/>
                    </div>
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
                <p>Наш контактный телефон"
                    8(900)900-90-00</p>
            </div>
        </div>
    </div>
</div>
