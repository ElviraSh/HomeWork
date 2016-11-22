package ru.kpfu.itis.ShalafaevaElvira.servlets.cart;

import ru.kpfu.itis.ShalafaevaElvira.utils.CartClass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by Elvira on 03.11.2016.
 */
public class AddToCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        CartClass shoppingCart;
        shoppingCart = (CartClass) session.getAttribute("cart");
        if (shoppingCart == null) {
            shoppingCart = new CartClass();
            session.setAttribute("cart", shoppingCart);
        }/*
        String image = request.getParameter("image");*/
        String name = request.getParameter("name");
        Integer price = Integer.parseInt(request.getParameter("price"));
        shoppingCart.addToCart(name, price);
        session.setAttribute("cart", shoppingCart);


        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html><html><head><meta http-equiv='Content-Type' content='text/html'; charset='utf-8'/>" +
                    "<title>CoffeeShop_сart</title><link rel='stylesheet' href='css/style.css'/></head><body>" +
                    "<div id='wrapper'><div class='panel-top'><div class='center clearfix'></div></div>" +
                   "<div id='home'><div class='home-bg'>" +
                    "<div class='center'><a href='/productsForUser.jsp?page=1' class='link-home'></a>" +
                    "<h2 class='title-home'><img src=\"img/hb-logo.png\" width=\"50px\" height=\"50px\">Coffee shop</h2></div></div></div>" +
                    "<div class='middle clearfix center'><div class='sidebar'></div><div class='content'>" +
                    "<div class='registr'><div class='header-login'><br><br><h4>КОРЗИНА</h4><br><br><br></div>");
            HashMap<String, Integer> items = shoppingCart.getCartItems();
            out.println("<div class='cartTable'><table border='1px' width='750px'><col width='460px'><col width='145px'><col width='145px'>");
            for (String key : items.keySet()) {
                out.println("<form action='deleteItem'><input type='hidden' name='name' value='" + key + "'>" +
                        "<tr><td>" + key + "</td ><td >" + items.get(key) + " руб.</td><td>" +
                        "<input type ='submit' class='button' value ='УДАЛИТЬ'></td></tr></form>");
            }
            out.println("</table></div><br/><br/><br/><form action='sum' method='POST'>" +
                    "<input type='submit' class='submit-class-login' name=btn' value='КУПИТЬ'></form></div>" +
                    "</div></div></div><div id=\"footer\">\n" +
                    "    <a href=\"#home-link\" class=\"home-link\">&nbsp;</a>\n" +
                    "    <div class=\"center clearfix\">\n" +
                    "        <div class=\"f-about\">\n" +
                    "            <h5 class=\"f-title\">Контакты</h5>\n" +
                    "            <p>Наш контактный телефон\"\n" +
                    "                8(900)900-90-00</p>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</div></body></html>");


        }
    }
}