<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="UTF-8">
    <title>Описание товара</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
%>

<div id="wrapper">
    <div class="panel-top">
        <div class="center clearfix">
            <div class="basket">
                <img src="img/cart.png" width="40px" height="30px" onclick="return confirm('Выберите какой-либо продукт прежде, чем перейти в Корзину')">
            </div>
        </div>
    </div>

    <div id="home">
        <div class="home-bg">
            <div class="center">
                <a href="productsForUser.jsp?page=1" class="link-home"></a>
                <h2 class="title-home">COFFEE SHOP</h2>
            </div>
        </div>
    </div>
    <div class="middle clearfix center">

        <div class="content">
            <div class="descr">
                <form class="simple_form" action="/addtocart" method="POST">
                    <div class="main">
                        <input type="hidden" name="product_id" value="<%=request.getParameter("product_id")%>">
                        <br/><br/>
                        НАЗВАНИЕ: <br/>
                        <div class="input-class2"><input type="hidden" name="name"
                                                         value="<%=request.getParameter("name")%>"><%=request.getParameter("name")%>
                        </div>
                        <br/>
                        <center>
                        <div class="input-class2"><img src="<%=request.getParameter("image")%>" height="400" width="400"
                                                 alt="Обложка"/></div></center>
                        </div>

                         <br/>
                        <div class="input-class2"><%=request.getParameter("description") %>
                        </div>
                        <br/><br/>
                        <div class="input-class2" style="margin-left: 15px"> ЦЕНА:<br/><br/>
                    <div class="input-class2"><input type="hidden" name="price"
                                     value="<%=request.getParameter("price")%>"><%=request.getParameter("price") %>
                        <br/><br/><br/></div><center>
                        <input type='submit' class='button' value='ДОБАВИТЬ В КОРЗИНУ'/></center>
                        </div>
                </form>
            </div>


        </div>
    </div>
</div>
<script>
    var request;
    function postComment() {
        var comment = document.commentform.comment.value;
        var email = document.commentform.email.value;
        var product = document.commentform.product.value;
        var url = "comment.jsp?comment=" + comment + "&email=" + email + "&product=" + product;
        if (window.XMLHttpRequest) {
            request = new XMLHttpRequest();
        }
        else if (window.ActiveXObject) {
            request = new ActiveXObject("Microsoft.XMLHTTP");
        }
        try {
            request.onreadystatechange = function () {
                if (request.readyState == 4) {
                    var val = request.responseText;
                    document.getElementById('mylocation').innerHTML = val;
                }
            }
            request.open("GET", url, true);
            request.send();
        } catch (e) {
            alert("Unable to connect to server");
        }
    }
</script>
<center>
    <form name="commentform">
        ВАШ КОММЕНТАРИЙ:<br/>
        <textarea name="comment" style="width:300px;height:100px" required></textarea><br/>
        ВАШЕ ИМЯ:<br/>
        <input type="text" name="email" required/><br/><br/>
        <input type="hidden" name="product" required value="<%=request.getParameter("product_id")%>"/><br/><br/>
        <input type="button" class="button" value="ДОБАВИТЬ КОММЕНТАРИЙ" onclick="postComment()">
    </form>
</center>
<span id="mylocation"></span>
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