<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.kpfu.itis.ShalafaevaElvira.objects.Coffee" %>

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
            <div class="login">
                <a href="login">Вход</a>
                <span>/</span>
                <a href="/registration1.jsp">Регистрация</a>
            </div>
        </div>
    </div>
    <%--<div id="header" class="center clearfix">
    </div>--%>
    <div id="home">
        <div class="home-bg">
            <div class="center">
                <a href="views/main_page.jsp" class="link-home"></a>
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
        <% for (Coffee coffee : coffeeList.getRecords(pageid, total)) {
        %>
        <div class="products2">
            <div class="p-img">
                    <center><input type="hidden" name="image" value="<%=coffee.getImage()%>"><img
                            src="<%=coffee.getImage()%>" height="220" width="210" style="margin-top: 30px" alt="Приносим наши извенения. Картинка в скором времени загрузится "/></center>
                </div>
            <div class="p-footer">
                <h6><input type="hidden" name="name"
                           value="<%=coffee.getName()%>"><%=coffee.getName()%>
                </h6>
                <input type="hidden" name="description" value="<%=coffee.getDescription()%>">
                <p><%=coffee.getDescription().substring(0, 50)%>...</p>
                <input type="hidden" name="product_id" value="<%=coffee.getId()%>">
                <div class="p-footer-product clearfix">
                        <span class="price"><input type="hidden" name="price"
                                                   value="<%=coffee.getPrice()%>"><%=coffee.getPrice()%> руб.</span>
                    <input type="submit" class="button" value="ОПИСАНИЕ"onclick="return confirm('Авторизуйтесь, чтобы открыть описание')"/>
                </div>
            </div>
        </div>
        <%}%>
    </div>
</div>
<center>
<a href="coffee.jsp?page=1">1</a>
<a href="coffee.jsp?page=2">2</a>

<a href="coffee.jsp?page=3">3</a>
</center>
<%--<c:forEach items="${for_count_pages}" var="item">
    <c:if ru.kpfu.itis.ShalafaevaElvira.test="${current_page != item}">
        <a href="<c:url value="/books?page=${item}"/>">${item} </a>
    </c:if>
    <c:if ru.kpfu.itis.ShalafaevaElvira.test="${current_page == item}">
        <span>${item} </span>
    </c:if>
</c:forEach>--%>
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