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
public class DeleteFromCart extends HttpServlet {
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
        String name = request.getParameter("name");
        HttpSession session = request.getSession();
        CartClass shoppingCart;
        shoppingCart = (CartClass) session.getAttribute("cart");
        shoppingCart.deleteFromCart(name);
        session.setAttribute("cart", shoppingCart);
        shoppingCart = (CartClass) session.getAttribute("cart");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><meta http-equiv='Content-Type' content='text/html'; charset='utf-8'/>" +
                    "<title>CoffeeShop_cart</title><link rel='stylesheet' href='css/style.css'/></head><body>" +
                    "<div id='wrapper'><div class='panel-top'><div class='center clearfix'></div></div>" +
                    "<div id='home'><div class='home-bg'>" +
                    "<div class='center'><a href='/views/jsp/productsForUser.jsp?page=1' class='link-home'></a>" +
                    "<h2 class='title-home'>COFFEE SHOP</h2></div></div></div>" +
                    "<div class='middle clearfix center'><div class='sidebar'></div><div class='content'>" +
                    "<div class='registr'><div class='header-login'><br><br><h4>КОРЗИНА</h4><br><br><br></div>");
            HashMap<String, Integer> items = shoppingCart.getCartItems();
            out.println("<div class='cartTable'><table border='1px' width='750px'><col width='460px'><col width='145px'><col width='145px'>");
            for (String key : items.keySet()) {
                out.println("<form action='deleteItem'><input type='hidden' name='name' value='" + key + "'><tr><td>" + key + "</td><td>" + items.get(key) + " руб.</td><td><input type='submit' class='button' value='УДАЛИТЬ'></td></tr></form>");
            }
            if (items.isEmpty()) {
                out.println("<div class=cartFont>Нет выбранных товаров</div>");
            }
            out.println("</table></div></div></div></div></div>");
            out.println("<div id=\"footer\">\n" +
                    "    <a href=\"#home-link\" class=\"home-link\">&nbsp;</a>\n" +
                    "    <div class=\"center clearfix\">\n" +
                    "        <div class=\"f-about\">\n" +
                    "            <h5 class=\"f-title\">Контакты</h5>\n" +
                    "            <p>Наш контактный телефон\"\n" +
                    "                8(900)900-90-00</p>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
