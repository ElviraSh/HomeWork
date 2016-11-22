package ru.kpfu.itis.ShalafaevaElvira.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Elvira on 12.11.2016.
 */
public  class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cookie[] cookies = req.getCookies();

        if(cookies!=null){
            for (Cookie cookie : cookies){
                if (cookie.getName().equals(session.getAttribute("email"))){
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                }

            }
        }
        session.invalidate();
        resp.sendRedirect("/login");
    }

}
