

package ru.kpfu.itis.ShalafaevaElvira.servlets;

import ru.kpfu.itis.ShalafaevaElvira.database.Products;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by Elvira on 21.09.2016.
 */
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 38044879686270933L;
    private Connection con;
    private Statement st;
    private ResultSet rs;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Cookie[] cookies = req.getCookies();
        HttpSession s = req.getSession();
        String email = req.getParameter("email");
        s.setAttribute("email", email);
        try {
            con = Products.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from users where email='" + email + "'");
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    String name = cookie.getName();
                    String password = cookie.getValue();
                    if (rs.next()) {
                        if (rs.getString(2).equals(password)) {
                            s.setAttribute("email", email);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
                if (rs != null) rs.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
            }
        }
        if (s.getAttribute("email") != null) {
            resp.sendRedirect("/productsForUser.jsp?page=1");
        } else {
            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter().print(
                    "<html>\n" +
                    "<head>\n" +
                    "    <link rel=\"stylesheet\" href=\"/css/Style_authorization.css\">\n" + "\n" +"<link rel='stylesheet' \" +\n" +
                    "                    \"href='css/style.css'/><link rel='stylesheet' \\\" +\\n\" +\n" +
                    "                    \"                    \\\"href='css/Style_authorization.css'/>"+
                    "    <link href=\"https://fonts.googleapis.com/css?family=Indie+Flower|Roboto\" rel=\"stylesheet\">"+ "<meta charset='UTF-8'>"+
                    "    <title>CoffeeShop_Авторизация</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div class='panel-top'><div class='center clearfix'>" +
                    "<div class='login'><a href='login'>Вход</a><span>/</span><a href='/registration1.jsp'>Регистрация</a></div></div></div>" +
                    "<div id=\"home\">\n" +
                            "        <div class=\"home-bg\">\n" +
                            "            <div class=\"center\">\n" +
                            "                <a href=\"coffee.jsp?page=1\" class=\"link-home\"></a>\n" +
                            "                <h2 class=\"title-home\"> <img src=\"img/hb-logo.png\" width=\"50px\" height=\"50px\">Coffee shop</h2>\n" +
                            "            </div>\n" +
                            "        </div>\n" +
                            "    </div></div></div>"+
                    "<div id=\"wrapper1\">\n" +

            "    <header>\n" +
                    "        <div class=signIn>Вход</div>\n" +
                    "    </header>\n" +
                    "    <section>\n" +
                    "        <form class=\"login_form\" method=\"post\">\n" +
                    "\n" +
                    "            <div class=\"text\">\n" +
                    "                <span class=\"input_name\">e-mail </span>\n" +
                    "                <input type='text' name='email' class='input-class' placeholder='e-mail'>\n" +
                    "            </div>\n" +
                    "\n" +
                    "\n" +
                    "            <div class=\"text\">\n" +
                    "                <span class=\"input_name\">password </span>\n" +
                    "                <input type='password' name='password' class='input-class' placeholder='Пароль'>\n" +
                    "            </div>\n" +
                    "            <input type='checkbox' checked='remember'>Remember</input>\n" +"<br>"+
                    "\n" +
                    "            <input type=\"submit\" class=\"button\" value=\"Sign In\">\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +

                    "\n" +
                    "\n" +
                    "\n" +
                    "        </form>\n" +
                    "    </section>\n" +
                    "</div>\n" +
                    "</body>\n" +
                    "</html>");
        }

    }
    public LoginServlet() {
        super();
    }
    public void destroy()// called just before servlet unload
    {
        System.out.println("Login Destroyed...");
        super.destroy();
    }
    public void init(ServletConfig config) throws ServletException// called once servlet loads
    {
        System.out.println("Login Init called...");
        try {
            super.init(config);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession s = req.getSession();
        if (s.getAttribute("email") != null) {
            resp.sendRedirect("/productsForUser.jsp?page=1");
        } else {
            String email = req.getParameter("email");
            s.setAttribute("email", email);
            String password = req.getParameter("password");
            boolean remember = req.getParameter("remember") != null;
            try {
                con = Products.getConnection();
                st = con.createStatement();
                rs = st.executeQuery("select * from users where email='" + email + "'");
                if (email.equals("admin@mail.ru") && password.equals("admin1"))
                    resp.sendRedirect("/productsForAdmin.jsp?page=1");
                else if (rs.next()) {
                    if (rs.getString(2).equals(password)) {
                        if (remember) {
                            Cookie cookie = new Cookie(email, password);
                            cookie.setMaxAge(10 * 10 * 10);
                            resp.addCookie(cookie);
                        }
                        s.setAttribute("email", email);
                        resp.sendRedirect("/productsForUser.jsp?page=1");
                    } else {
                        resp.sendRedirect("/login?error_msg=Password+invalid&password=" + email);
                    }
                } else {
                    resp.sendRedirect("/login?error_msg=Username+not+registered&username=" + email);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (st != null) st.close();
                    if (rs != null) rs.close();
                    if (con != null) con.close();
                } catch (SQLException ex) {
                }
            }
        }

            System.out.println("Login doPost...");
            String email = req.getParameter("email");
            String pwd = req.getParameter("password");
            String remember = req.getParameter("remember");
            System.out.println("User: "+email+" | password: "+pwd);
            if(email.equals("admin@mail.ru") && pwd.equals("admin1")) {
                HttpSession session=req.getSession();
                session.setAttribute("email", email);
                Cookie ck1 = new Cookie("email", email);
                resp.addCookie(ck1);
                if(remember!=null && remember!="") {
                    Cookie ck3 = new Cookie("remember", remember);
                    resp.addCookie(ck3);
                }}
        PrintWriter out= resp.getWriter();
        RequestDispatcher rd=req.getRequestDispatcher("/productsForUser.jsp?page=1");
        /*rd.forward(req, resp);*//*
        resp.sendRedirect("/productsForAdmin.jsp");*/
    }
}