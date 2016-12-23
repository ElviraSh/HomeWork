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
 * Created by Elvira on 10.11.2016.
 */
public class SumServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String name = req.getParameter("name");
        HttpSession session = req.getSession();
        CartClass shoppingCart;
        shoppingCart = (CartClass) session.getAttribute("cart");
        shoppingCart.deleteFromCart(name);
        session.setAttribute("cart", shoppingCart);
        shoppingCart = (CartClass) session.getAttribute("cart");
        PrintWriter out = resp.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><meta http-equiv='Content-Type' content='text/html'; charset='utf-8'/>" +
                    "<title>CoffeeShop_cart</title><link rel='stylesheet' href='css/style.css'/></head><body>" +
                    "<div id='wrapper'><div class='panel-top'><div class='center clearfix'></div></div>" +
                    "<div id='home'><div class='home-bg'>" +
                    "<div class='center'><a href='productsForUser.jsp?page=1' class='link-home'></a>" +
                    "<h2 class='title-home'>COFFEE SHOP</h2></div></div></div>" +
                    "<div class='middle clearfix center'><div class='sidebar'></div><div class='content'>" +
                    "<div class='registr'>");
            HashMap<String, Integer> items = shoppingCart.getCartItems();
            int sum = 0;
            for (String key : items.keySet()) {
                sum = sum + items.get(key);
            }
            out.println("<div class='header-cart'><br/><br/><br/><br/><h4>СУММА ВАШЕГО ЗАКАЗА СОСТАВИЛА " + sum + " РУБЛЕЙ</h4><br><br><br></div></div></div></div></div>");
            out.println("<div id='footer'><a href='#home-link' class='home-link'>&nbsp;</a>" +
                    "<div class='center clearfix'><div class='f-about'><h5 class='f-title'>Контакты</h5>" +
                    "<p>Наш интернет-магазин кофе 'Coffee_Shop' " +
                    "8(900)900-90-00</p></div></div></div>");
            out.println("</body>");
            out.println("</html>");
        }catch (Exception e) {
        }
    }
}
