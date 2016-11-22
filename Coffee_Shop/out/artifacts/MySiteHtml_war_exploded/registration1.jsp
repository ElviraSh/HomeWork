<%--
  Created by IntelliJ IDEA.
  User: Elvira
  Date: 04.11.2016
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js"/>"></script>



<html lang="en">
<head>
    <meta charset="UTF-8">

    <% request.setCharacterEncoding("utf-8"); %>
    <% response.setCharacterEncoding("utf-8"); %>
    <title>CoffeeShop_Регистрация</title>
    <link rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript" src="<c:url value="/js/check_form.js"/>"></script>

</head>
<body>
<script type="text/javascript" src="/js/checkForm.js"></script>

<div id="wrapper">
    <div class="panel-top">
        <div class="center clearfix">
            <div class="login">
                <a href="login">Sign In</a>
                <span>/</span>
                <a href="/registration1.jsp">Sign Up</a>
            </div>
        </div>
    </div>

    <div id="home">
        <div class="home-bg">
            <div class="center">
                <a href='/coffee.jsp?page=1' class='link-home'></a>
                <h2 class="title-home"> <img src="img/hb-logo.png" width="50px" height="50px">Coffee shop</h2>
            </div>
        </div>
    </div>
    <div class="middle clearfix center">
        <div class="sidebar"></div>
        <div class="content">
            <div class="register">
                <p>${message}</p><br>
                <div class="wrapper2">
                    <header><br><br>
                        <h1>Sign Up</h1><br>
                        <p id="p1">Want to sign up fill out this form!</p><br>
                    </header>
                    <section>
                        <form class="form" action="<c:url value="/register"/>" method="POST">

                            <div class="text">

                                <div class="fname">
                                <span class="input_name">First Name </span>
                                    <input comm_id="name" class="input-class" type="text" value="${param.name}" name="username"
                                           placeholder="Name">
                                    <br>
                                    </div>


                                <div class="femail">
                                <span class="input_name">e-mail </span>
                                    <input comm_id="email" class="input-class" type='email' value="${param.email}" name='email'
                                           placeholder='Email'>
                                    <br>
                                </div>

                                    <div class="fpassword">
                                <span class="input_name">Password </span>
                                        <input comm_id="password1" class="input-class" type='password' name='password1' placeholder='**************'>
                                        <br>




                                <span class="input_name">Please, repeat your password </span>

                                        <input comm_id="password2" class="input-class" type='password' name='password2'
                                               placeholder='**************'>
                                        </div>
                                <br>
                            </div>

                                <input comm_id="btn_check" type="submit" class="button" name="btn"
                                       value="Sign Up">


                        </form>
                    </section>










                </div>
            </div>
        </div>
    </div>

</div>


</body>
</html>

